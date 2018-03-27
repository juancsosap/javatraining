package Logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import Cosmos.ILocalable;

public class GlobalLogger {

	private final Logger LOGGER = Logger.getLogger("GlobalGameLog");
	
	private static GlobalLogger instance = null;
	
	private GlobalLogger() {
		
			LogManager.getLogManager().reset();
			this.LOGGER.setLevel(Level.ALL);
			
			ConsoleHandler consoleHandler = new ConsoleHandler();
			consoleHandler.setLevel(Level.WARNING);
			this.LOGGER.addHandler(consoleHandler);
		
		try {
			FileHandler fileHandler = new FileHandler("global.log", true);
			fileHandler.setLevel(Level.FINE);
			this.LOGGER.addHandler(fileHandler);
		} catch (Exception e) {
			String msg = "Error with the Logging System: " + e.getMessage();
			this.LOGGER.log(Level.SEVERE, msg);
		}
	}
	
	public void log(ILocalable item, Level level, String msg) {
		msg = item.getURL() + " : " + msg;
		this.LOGGER.log(level, msg);
	}
	
	public static GlobalLogger getLogger() {
		if(instance == null)
			instance = new GlobalLogger();
		return instance;
	}
	
}
