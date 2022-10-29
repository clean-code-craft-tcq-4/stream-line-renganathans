package com.tcq.training.bms.loggerImpl;

import com.tcq.training.bms.api.ILogger;

public class ConsoleLogger implements ILogger {

	@Override
	public void log(String data) {
		System.out.println(data);
	}

}
