/* DarkHelp - C++ helper class for Darknet's C API.
 * Copyright 2019-2024 Stephane Charette <stephanecharette@gmail.com>
 * MIT license applies.  See "license.txt" for details.
 */

#include "DarkHelp.hpp"
#include <vector>
#include <cmath>
#include <numeric>
#include <array>
#include <iostream>
#include <vector>
#include <opencv2/opencv.hpp>
#include <opencv2/core/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/calib3d/calib3d.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <chrono>

using namespace std;


std::vector<double> linespace(double start, double end, int num)
{
    std::vector<double>  linspaced;
    //cout << start << " " <<  end << " " << num <<  endl;

    if (1 == num)
    {
        linspaced.push_back(start);
    }
    else
    {
        double delta = (end - start) / (num - 1);

        for (auto i = 0; i < (num - 1); ++i)
        {
            linspaced.push_back(static_cast<double>(start + delta * i));
        }
        // ensure that start and end are exactly the same as the input
        linspaced.push_back(end);
    }

    return linspaced;
}


int main(int argc, char * argv[])
{
    //double speed = 0.0;
    double X = 0;
    double Y = 0;
    double velocity_x = 0;
    double velocity_y = 0;
    double velocity_z = 0;
    double t = 0;
    int rc = 0;
    int X0 = 0;
    int Y0 = 0;
    double Z0 = 0;
    int X1 = 0;
    int Y1 = 0;
    double Z1 = 0;
    //double height0 = 0;
    //double width0 = 0;
    //double height1= 0;
    //double width1= 0;
    //vector<double> distanceX;
    //vector<double> distanceY;
    //double totalDistanceX = 0;
    //double totalDistanceY = 0;

    //const double ball_Width = 6.8;      //size of soccer ball in cm
    //const double ball_Height = 6.8;     //size of soccer ball in cm
    double actual_delta_t = 0.0333;     // For 30 FPS
    double delta_t = 0.0333; 	        // For 30 FPS
    double desired_fps = 30.0;
    int delay_ms = static_cast<int>(1000.0 / desired_fps); // Convert FPS to milliseconds


    try
    {
        DarkHelp::Config cfg("/home/cole/Desktop/src/darknet/cfg/yolov4-tiny-custom.cfg", "/home/cole/Desktop/src/darknet/yolov4.weights", "/home/cole/Desktop/src/darknet/data/obj.names");
        cfg.enable_tiles                    = false;
        cfg.annotation_auto_hide_labels        = false;
        cfg.annotation_include_duration        = true;
        cfg.annotation_include_timestamp    = false;
        cfg.threshold                        = 0.2f;
        // lots of other options, scroll down this page to see what can be done:  https://www.ccoderun.ca/darkhelp/api/classDarkHelp_1_1Config.html#details

        DarkHelp::NN nn(cfg);


        // Use OpenCV to open the webcam.  Index zero is the first webcam.  Attemp to set a few camera properties.
        cv::VideoCapture cap(0);
        if (not cap.isOpened())
        {
            throw std::runtime_error("failed to open the webcam");
        }
        cap.set(cv::CAP_PROP_FRAME_WIDTH, 640.0);
        cap.set(cv::CAP_PROP_FRAME_HEIGHT, 480.0);
        cap.set(cv::CAP_PROP_FPS, 30.0);

        //While no prediction been made
        while (X == 0 && Y == 0)
        {


            cv::Mat frame;
            cap >> frame;
            if (frame.empty())
            {
                break;
            }

            const auto results = nn.predict(frame);


            //Get x, y, and z (area) coordinates
            //-------------------------------------------------------
            for (auto j = 0u; j < results.size(); j++) {
                X1 = round(results[j].original_point.x * 100);
                Y1 = round(results[j].original_point.y * 100);
                Z1 = round((static_cast<double>(results[j].rect.width) / 640) * (static_cast<double>(results[j].rect.height) / 480) * 10000) / 100;
                //height1 = results[j].rect.height / ball_Height;
                //width1 = results[j].rect.width / ball_Width;
            }

            frame = nn.annotate();

            //If we have at least 2 coordinates we can calculate speed and velocity
            if (Z0 != 0 && Z1 != 0) {
                /*
                if (abs(X1 - X0) != 0)
                    distanceX = linespace(width0, width1, abs(X1 - X0));
                if (abs(Y1 - Y0) != 0)
                    distanceY = linespace(height0, height1, abs(Y1 - Y0));
                cout << distanceX << " " << distanceY << endl;
                cout << "BEFORE accumulate" << endl;
                totalDistanceX = std::accumulate(distanceX.begin(), distanceX.end(), 0.0);
                totalDistanceY = std::accumulate(distanceY.begin(), distanceX.end(), 0.0);
                cout << "AFTER accumulate" << endl;
                speed = (std::sqrt(std::pow(totalDistanceX, 2) + std::pow(totalDistanceY, 2)) / actual_delta_t);
                */
                velocity_x = (X1 - X0) / actual_delta_t;
                velocity_y = (Y1 - Y0) / actual_delta_t;
                velocity_z = (Z1 - Z0) / actual_delta_t;
            }


            //The ball exist and IS at close proximity cut off point (4 is current placeholder)
            if (Z0 != 0 && Z1 >= 4) {
                //calculate t given z(t) = 6 (6 is current placeholder for area of ball when crossing goalie)
                t = (6 -  Z0) / velocity_z;
                //Find X,Y coordinate by plugging t value into their position formula
                X = X0 + (velocity_x * t);
                Y = Y0 + (velocity_y * t);
            }

            //std::cout << "\nX0: " << X0 <<  " Y0: " << Y0 << " Z0: " << Z0 << std::endl;
            //std::cout << "\nX1: " << X1 <<  " Y1: " << Y1 << " Z1: " << Z1 << std::endl;


            //New coordinates become our old coordinates
            if (Z1 != 0) {
                X0 = X1;
                Y0 = Y1;
                Z0 = Z1;
                //width0 = width1;
                //height0 = height1;
                //X1 = Y1 = Z1 = height1 = width1 = 0;
                X1 = Y1 = Z1 = 0;
                actual_delta_t = delta_t;
            }
            else {
                actual_delta_t += delta_t;
            }

            imshow("video", frame);
            const auto key = cv::waitKey(delay_ms);
            if (key == 27)
            {
                break;
            }

        }
    }
    catch (const exception & e)
    {
        cout << e.what() << endl;
        rc = 1;
    }

    //Mapping

    // row = 0 col = 0
    if (X > 65 && X < 110 && Y > 0 && Y < 50) {
        X = 0;
        Y = 0;
    }
    // row = 1 col = 0
    else if (X > 65 && X < 110 && Y > 50 && Y < 110) {
        X = 1;
        Y = 0;
    }
    // row = 0 col = 1
    else if (X > 30 && X < 60 && Y > 0 && Y < 50) {
        X = 0;
        Y = 1;
    }
    // row = 1 col = 1
    else if (X > 40 && X < 65 && Y > 50 && Y < 110) {
        X = 1;
        Y = 1;
    }
    // row = 0 col = 2
    else if (X > -10 && X < 40 && Y > 0 && Y < 40) {
        X = 0;
        Y = 2;
    }
    // row = 2 col = 3
    else if (X > -10 && X < 40 && Y > 40 && Y < 110) {
        X = 1;
        Y = 2;
    }
    // Out Of bounds
    else {
        X = 2;
        Y = 2;
    }

    //std::cout << "\nPrediction: " << X << ", "  << Y << std::endl;
    //Send values to the GUI
    std::cout << X << std::endl;
    std::cout << Y << std::endl;

    return rc;
}

