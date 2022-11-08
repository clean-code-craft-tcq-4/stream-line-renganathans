#include "json/json.h"
#include "iostream"
#include "fstream"
using namespace std;
const int NO_OF_READINGS = 10;
const int NReadings = 5;
int tempArray[NO_OF_READINGS];
int SOCArray[NO_OF_READINGS];
void parseJson();
void SMA();
void getMinAndMax(int *tempArray, int *SOCArray);