package com.tcq.training.bms.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcq.training.bms.api.ILogger;
import com.tcq.training.bms.api.LoggerFactory;
import com.tcq.training.bms.dataContainer.DataContainer;
import com.tcq.training.bms.dataContainer.DataUtil;

public class BatteryManangement {

	DataContainer dataContainer;

	ILogger logger;

	DataUtil dataUtil;

	/**
	 * Entry Point
	 * 
	 * @param args
	 * @throws JsonProcessingException
	 */
	public static void main(String[] args) throws JsonProcessingException {

		BatteryManangement batteryManangement = new BatteryManangement();
		batteryManangement.startApplication();
	}

	/**
	 * This method is responsible to get logger , to initiate data , get data in
	 * json and send
	 * 
	 * @throws JsonProcessingException
	 */
	public void startApplication() throws JsonProcessingException {
		logger = LoggerFactory.getLogger("console");
		dataUtil = new DataUtil();

		initiateData();

		String dataToSend = getDataAsJson();

		if (dataToSend != null)
			printData(dataToSend);

	}
	
	/**
	 * Populate 50 Battery Data 
	 * @throws JsonProcessingException
	 */
	public void initiateData() throws JsonProcessingException {

		dataContainer = dataUtil.populateData(50);

	}
	
	/**
	 * Converts the Data present in dataContainer to Json
	 * @return Data to send as Json
	 * @throws JsonProcessingException
	 */
	public String getDataAsJson() throws JsonProcessingException {
		if (dataUtil != null)
			return dataUtil.parseAsJson(dataContainer);
		return null;
	}

	/**
	 * Print the data
	 * @param data
	 */
	private void printData(String data) {

		if (null != logger) {
			logger.log(data);
		}
	}
}
