package com.tcq.training.bms.battery.parameters;

public class BatteryParameters {

	Double soc;

	Double temperature;

	/** 
	 * Get the State-of-charge
	 * @return soc
	 */
	public Double getSoc() {
		return soc;
	}

	/**
	 * Set the State-of-charge
	 * @param soc
	 */
	public void setSoc(Double soc) {
		this.soc = soc;
	}

	/**
	 * Get battery Temperature
	 * @return temperature
	 */
	public Double getTemperature() {
		return temperature;
	}

	/**
	 * Set battery Temperature
	 *  @param temperature
	 */
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "BatteryParameters [soc=" + soc + ", temperature=" + temperature + "]";
	}

	

}
