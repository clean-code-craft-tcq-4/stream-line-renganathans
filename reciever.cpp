#include "reciever.hpp"

using namespace std;
void parseJson() {
	std::ifstream file_input("Output.json");
	Json::Reader reader;
	Json::Value root;
	reader.parse(file_input, root);

	Json::Value readings = root[""];

	for (int i = 0;i < NO_OF_READINGS;i++) {
		SOCArray[i] = readings[i]["soc"].asFloat();
		tempArray[i] = readings[i]["temperature"].asInt();
	}
	for (int i = 0;i < NO_OF_READINGS;i++) {
		cout << SOCArray[i] << tempArray[i];
	}
}
void getMinAndMax(int* tempArray, int* SOCArray) {
	int len1 = sizeof(tempArray)/sizeof(tempArray[0]);
	int len2 = sizeof(SOCArray)/sizeof(SOCArray[0]);
	std::sort(tempArray,tempArray+len1);
	std::sort(SOCArray,SOCArray+len2);
	cout << tempArray[0], SOCArray[0], tempArray[len1], SOCArray[len2];
}
void SMA(){
	float SOCMean, tempMean,SOCAvg = 0.0;
	int tempAvg = 0;
	for (int i = 0;i < NO_OF_READINGS;i++) {
		if(NO_OF_READINGS < NReadings)
			SOCAvg = SOCAvg + SOCArray[i];
			tempAvg = tempAvg + tempArray[i];
	}
	SOCMean = SOCAvg / NReadings;
	tempMean = tempAvg / NReadings;
	cout << SOCMean << tempMean;
}
int main() {
	parseJson();
	getMinAndMax(tempArray,SOCArray);
	SMA();
	return 0;
}