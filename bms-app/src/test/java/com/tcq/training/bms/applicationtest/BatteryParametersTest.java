package com.tcq.training.bms.applicationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.tcq.training.bms.battery.parameters.BatteryParameters;
import com.tcq.training.bms.dataContainer.DataContainer;
import com.tcq.training.bms.dataContainer.DataUtil;

public class BatteryParametersTest {
	DataContainer dataContainer;

//	BatteryManangement batteryManangement;
//
//	// @BeforeClass
//	public void init() throws JsonProcessingException {
//		batteryManangement = new BatteryManangement();
//		batteryManangement.initiateData();
//	}

	@Test
	public void testDataCount() {
		DataUtil dataUtil = new DataUtil();
		dataContainer = dataUtil.populateData(50);
		assertNotNull(dataContainer.getBatteryParameters());
		assertEquals(dataContainer.getBatteryParameters().size(), 50);
	}

	@Test
	public void testDataRangeForTemaperature() {
		DataUtil dataUtil = new DataUtil();
		dataContainer = dataUtil.populateData(50);
		List<BatteryParameters> batteryParameters = dataContainer.getBatteryParameters();
		for (BatteryParameters batteryParameter : batteryParameters) {
			Double temperature = batteryParameter.getTemperature();
			assertTrue(temperature >= 0 && temperature <= 40);
		}

	}

	@Test
	public void testDataRangeForSoc() {
		DataUtil dataUtil = new DataUtil();
		dataContainer = dataUtil.populateData(50);
		List<BatteryParameters> batteryParameters = dataContainer.getBatteryParameters();
		for (BatteryParameters batteryParameter : batteryParameters) {
			Double soc = batteryParameter.getSoc();
			assertTrue(soc >= 20 && soc <= 80);
		}

	}
}
