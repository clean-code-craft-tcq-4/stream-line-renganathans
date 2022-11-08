package com.tcq.training.bms.dataContainer;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tcq.training.bms.battery.parameters.BatteryParameters;

public class DataUtil {

	public static float MAX_TEMPERATURE = 40f;
	public static float MIN_TEMPERATURE = 0f;
	public static float MAX_SOC = 80f;
	public static float MIN_SOC = 20f;

	private Double generateValue(float mAX_TEMPERATURE2, float mIN_TEMPERATURE2) {
		double value = Math.round(((Math.random() * (mIN_TEMPERATURE2 - mAX_TEMPERATURE2)) + mAX_TEMPERATURE2) * 100);
		return (value / 100.0f);
	}

	/**
	 * Populate the data with given count
	 * @param count
	 * @return DataContainer
	 */
	public DataContainer populateData(int count) {
		DataContainer dataContainer = new DataContainer();
		List<BatteryParameters> batteryParameters = new ArrayList<BatteryParameters>();
		for (int i = 0; i < count; i++) {
			BatteryParameters batteryParameter = new BatteryParameters();
			batteryParameter.setTemperature(generateValue(MAX_TEMPERATURE, MIN_TEMPERATURE));
			batteryParameter.setSoc(generateValue(MAX_SOC, MIN_SOC));
			batteryParameters.add(batteryParameter);
		}
		dataContainer.setBatteryParameters(batteryParameters);
		return dataContainer;
	}
	
	/**
	 * Convert the data present in dataContainer to json
	 * @param dataContainer
	 * @return data in json format 
	 * @throws JsonProcessingException
	 */
	public String parseAsJson(DataContainer dataContainer) throws JsonProcessingException {
		if (dataContainer != null) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);

			return mapper.writeValueAsString(dataContainer.getBatteryParameters());
		}
		return null;
	}
}
