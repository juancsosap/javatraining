package GraphCalculator;

public class Calculator {
	
	private DisplayPanelCalculator display;
	private long currentLongNumber;
	private long lastLongNumber = 0;
	private ButtonCalc lastOperator = ButtonCalc.ADDITION;
	
	public void setDisplay(DisplayPanelCalculator display) {
		this.display = display;
	}
	
	private boolean isValidNumber(String number) {
		boolean valid = true;
		try {
			Long.parseLong(number);
		} catch(NumberFormatException e) {
			valid = false; 
		}
		return valid;
	}
	
	private String formatNumber(String number) {
		long longNumber = Long.parseLong(number);
		this.currentLongNumber = longNumber;
		
		String stringNumber = longNumber + "";
		String output = "";
		if(longNumber < 0) { // "-234567890"
			stringNumber = stringNumber.substring(1);
		} // "234567890"
		for(int i=0; i<stringNumber.length()-1; i++) {
			output = stringNumber.charAt(stringNumber.length()-i-1) + output;
			if((i+1)%3 == 0) {
				output = "." + output;
			}	
		} // "234.567.890"
		output = stringNumber.charAt(0) + output;
		if(longNumber < 0) {
			output = "-" + output;
		} // "-234.567.890"
		System.out.println("Value: " + output);
		
		return output;
	}
	
	public void sendCommand(ButtonCalc cmd) {
		this.display.focusDisplay();
		ButtonType commandType = cmd.getType();
		long result;
		switch(commandType) {
			case NUMBER:
				String newDisplay = currentLongNumber + cmd.getLabel();
				if(!this.isValidNumber(newDisplay)) {
					newDisplay = currentLongNumber + "";
				}
				if(newDisplay.length() <= 9) {
					newDisplay = this.formatNumber(newDisplay);
					this.display.setDisplay(newDisplay);
				}
				break;
			case OPERATOR:
				switch(this.lastOperator) {
					case ADDITION:
						result = this.lastLongNumber + this.currentLongNumber; 
						break;
					case SUBSTRACTION:
						result = this.lastLongNumber - this.currentLongNumber;
						break;
					case MULTIPLICATION:
						result = this.lastLongNumber * this.currentLongNumber;
						break;
					case DIVITION:
						result = this.lastLongNumber / this.currentLongNumber;
						break;
					default: // EQUAL
						result = this.lastLongNumber;
						break;
				}
				this.display.setDisplay(this.formatNumber(result + ""));
				this.lastLongNumber = this.currentLongNumber;
				this.currentLongNumber = 0;
				this.lastOperator = cmd;
				break;
			case FUNCTION:
				switch(cmd) {
					case PERCENTAGE:
						result = this.currentLongNumber / 100; 
						this.currentLongNumber = result;
						break;
					case SQRT:
						result = (long) Math.sqrt(this.currentLongNumber);
						this.currentLongNumber = result;
						break;
					case SQUARE:
						result = (long) Math.pow(this.currentLongNumber, 2);
						this.currentLongNumber = result;
						break;
					case INVERSE:
						result = 1 / this.currentLongNumber;
						this.currentLongNumber = result;
						break;
					case CLEAR_ALL:
						result = 0;
						this.currentLongNumber = 0;
						this.lastLongNumber = 0;
						this.lastOperator = ButtonCalc.ADDITION;
						break;
					case CLEAR:
						result = 0;
						this.currentLongNumber = 0;
						break;
					case DELETE: // "1234567890"   "123456789"
						String value = this.currentLongNumber + "";
						result = Long.parseLong(value.substring(0, value.length()-1));
						// result = this.currentLongNumber / 10;
						this.currentLongNumber = result;
						break;
					default: // NEGATION
						result = -this.currentLongNumber;
						this.currentLongNumber = result;
						break;
				}
				this.display.setDisplay(this.formatNumber(result + ""));
				break;
		}
	}
	
	public void sendCommand(String cmd) {
		if(ButtonCalc.isValid(cmd)) {
			this.sendCommand(ButtonCalc.getButtonCalc(cmd));
		}
	}

}




