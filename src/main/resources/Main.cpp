#include <iostream>
#include <random>

int main() {

    // Initialize random number generator
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> disRow(0, 11); // Random row between 0 and 11
    std::uniform_int_distribution<int> disCol(0, 5);  // Random column between 0 and 5

    // Generate random coordinates
    int row = disRow(gen);
    int col = disCol(gen);

    // Send random coordinates to stdout
    std::cout << row << " " << col << std::endl;

    return 0;
}
