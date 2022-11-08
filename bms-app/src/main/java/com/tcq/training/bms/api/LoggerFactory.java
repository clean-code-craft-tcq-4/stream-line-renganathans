package com.tcq.training.bms.api;

import com.tcq.training.bms.loggerImpl.ConsoleLogger;

public class LoggerFactory {
	
	/**
	 * Initialize and Returns the object of Logger
	 * @param logger type
	 * @return object of Logger
	 */
	public static ILogger getLogger(String logger) {
		
		if(logger != null && !logger.isEmpty()) {
			if(logger.equalsIgnoreCase("console")) {
				return new ConsoleLogger();
			}
		}
		return null;
		
	}
}
