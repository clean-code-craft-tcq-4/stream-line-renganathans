package com.tcq.training.bms.dataContainer;

import java.util.ArrayList;
import java.util.List;

import com.tcq.training.bms.battery.parameters.BatteryParameters;

public class DataContainer {

	List<BatteryParameters> batteryParameters = new ArrayList<BatteryParameters>();

	public List<BatteryParameters> getBatteryParameters() {
		return batteryParameters;
	}

	public void setBatteryParameters(List<BatteryParameters> batteryParameters) {
		this.batteryParameters = batteryParameters;
	}

}
