package com.tcq.training.bms.applicationtest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tcq.training.bms.battery.parameters.BatteryParameters;
import com.tcq.training.bms.dataContainer.DataContainer;
import com.tcq.training.bms.dataContainer.DataUtil;

public class BMSDataSenderContentTest {
	static DataContainer dataContainer;

	static List<BatteryParameters> batteryParameters;

	@BeforeClass
	public static void init() throws JsonProcessingException {
		BatteryParameters batteryParameter = new BatteryParameters();
		batteryParameter.setSoc((double) 50);
		batteryParameter.setTemperature((double) 35);

		batteryParameters = new ArrayList<BatteryParameters>();
		batteryParameters.add(batteryParameter);

		dataContainer = new DataContainer();
		dataContainer.setBatteryParameters(batteryParameters);

	}
	
	@Test
	public void testSenderData() throws JsonProcessingException {
		DataUtil dataUtil = new DataUtil();
		String dataToSend = dataUtil.parseAsJson(dataContainer);
		String expectedOutput = "[{[" + System.lineSeparator() + "\"soc\":50.0," + System.lineSeparator() + "\"temperature\":35.0"
				+ System.lineSeparator() + "]" + System.lineSeparator() + "}]";
		assertEquals(expectedOutput.replaceAll(" ", "").trim(), dataToSend.replaceAll(" ", "").trim());
	}
	
}
