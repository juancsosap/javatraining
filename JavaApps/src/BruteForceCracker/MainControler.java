package BruteForceCracker;

import java.util.Date;

public class MainControler {

	private static final String UPPERCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCHARS = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SYMBOLS = ".:,;-_<>?¿!¡#$%&/\\\"'()[]{}+*=~°|^ ";
	
	private static BruteForceCalculator bgThread;
	
	private static boolean enable = true;
	
	public static int length = 0;
	public static long count = 0;
	public static String testPassword = "";
	public static long ti;
	public static int[] password;
	public static String chars = "";
	
	public static void initialLoad(MainPane src) {
		src.tfLength.setOnKeyReleased(ke -> MainControler.verifyOptions(src));
		src.ckLowerLetters.setOnAction(ae -> MainControler.verifyOptions(src));
		src.ckUpperLetters.setOnAction(ae -> MainControler.verifyOptions(src));
		src.ckNumbers.setOnAction(ae -> MainControler.verifyOptions(src));
		src.ckSymbols.setOnAction(ae -> MainControler.verifyOptions(src));
		src.btCalculate.setOnAction(ae -> {
			if(enable) { calculatePassword(src); }
			else { bgThread.cancel(); }
		});
	}
	
	public static void verifyOptions(MainPane src) {
		boolean isValid = src.ckLowerLetters.isSelected() || src.ckUpperLetters.isSelected() ||
		  		          src.ckNumbers.isSelected() || src.ckSymbols.isSelected();
		isValid &= src.tfLength.getText().matches("[1-9][0-9]*");
		isValid |= !enable;
		src.btCalculate.setDisable(!isValid);
	}
	
	private static void calculatePassword(MainPane src) {
		
		count = 0;
		
		src.btCalculate.setText("Cancel");
		disableFields(src, true);
		
		enable = false;

		chars = "";
		chars += src.ckLowerLetters.isSelected() ? LOWERCHARS : "";
		chars += src.ckUpperLetters.isSelected() ? UPPERCHARS : "";
		chars += src.ckNumbers.isSelected() ? NUMBERS : "";
		chars += src.ckSymbols.isSelected() ? SYMBOLS : "";
		
		length = Integer.parseInt(src.tfLength.getText());
		int totalChars = chars.length();
		char lastChar = chars.charAt(chars.length()-1);
		
		src.tfCharacteres.setText(totalChars + "");
				
		// Generate Test Password with all chars equal to the last char to be tested
		for(int i=0; i<length; i++) {
			testPassword += lastChar;
		}
		
		ti = (new Date()).getTime();
		
		// Test Different Length Passwords
		password = new int[length];
	    String[] finalPassword = new String[length];
	    for (int i = 0; i < length; i++) {
	    	password[i] = 0;
	    	finalPassword[i] = "";
	    }
	    
	    bgThread = new BruteForceCalculator();
				
		bgThread.setOnSucceeded(wse -> {
			src.btCalculate.setText("Calculate");
			disableFields(src, false);
			
			enable = true;
			
			src.tfTime.textProperty().unbind();
			src.tfPassword.textProperty().unbind();
			src.tfValues.textProperty().unbind();
		});
		
		bgThread.setOnCancelled(wse -> {
			src.btCalculate.setText("Calculate");
			disableFields(src, false);
			
			enable = true;
			
			src.tfTime.textProperty().unbind();
			src.tfPassword.textProperty().unbind();
			src.tfValues.textProperty().unbind();
		});
		
		src.tfTime.textProperty().bind(bgThread.messageProperty());
		src.tfPassword.textProperty().bind(bgThread.titleProperty());
		src.tfValues.textProperty().bind(bgThread.valueProperty());
		
		bgThread.restart();
		
	}
	
	private static void disableFields(MainPane src, boolean value) {
		src.ckLowerLetters.setDisable(value);
		src.ckUpperLetters.setDisable(value);
		src.ckNumbers.setDisable(value);
		src.ckSymbols.setDisable(value);
		src.tfLength.setDisable(value);
		src.lbLength.setDisable(value);
		src.lbCharacters.setDisable(value);
	}
	
}
