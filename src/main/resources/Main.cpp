#include <iostream>
#include <random>

// C++ Program to show how to use
// sleep function
#include <iostream>

// Library effective with Windows
#include <windows.h>

// Library effective with Linux
#include <unistd.h>

using namespace std;

int main() {

    sleep(5);

    // Initialize random number generator
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> disRow(0, 11); // Random row between 0 and 11
    std::uniform_int_distribution<int> disCol(0, 5);  // Random column between 0 and 5
    std::uniform_int_distribution<int> dist(20, 80); // Define the distribution


    // Generate random coordinates
    int row = disRow(gen);
    int col = disCol(gen);
    int speed = dist(gen);

    // Return the values as an array
    std::cout << row << std::endl;
    std::cout << col << std::endl;
    std::cout << speed << std::endl;

    return 0;
}
