package SimpleCalculator;

// This class offer the tools to process and calculate using INTEGERS with infinite number of digits 
public class IntegerNumber {
	
	private String number;
	// Only INTEGER NumberRegex values offer right operation of the class
	private NumberRegex regex;
	
	// Initialize the object with the value 0 and NumberRegex UNSIGNED_INTEGER 
	public IntegerNumber() {
		setNumber("0");
	}
	
	// Initialize the object with the integer value specified and NumberRegex UNSIGNED_INTEGER
	// If the value isn't valid for this NumberRegex the method generate and IllegalArgumentException 
	public IntegerNumber(int number) {
		setNumber(String.valueOf(number));
	}
	
	// Initialize the object with the value specified and NumberRegex UNSIGNED_INTEGER
	// If the value isn't valid for this NumberRegex the method generate and IllegalArgumentException 
	public IntegerNumber(String number) throws IllegalArgumentException {
		setNumber(number);
	}
	
	// Initialize the object with the value and NumberRegex specified
	// If the value isn't valid for this NumberRegex the method generate and IllegalArgumentException
	public IntegerNumber(String number, NumberRegex regex) throws IllegalArgumentException {
		setNumber(number, regex);
	}
	
	// Set the number and regex with the values specified 
	// If the value isn't valid for this NumberRegex the method generate and IllegalArgumentException
	public void setNumber(String number, NumberRegex regex) throws IllegalArgumentException {
		if(IntegerNumber.isValid(number, regex)) {
			this.number = number;
			this.regex = regex;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	// Set the number with the value specified and the regex with the NumberRegex UNSIGNED_INTEGER
	// If the value isn't valid for this NumberRegex the method generate and IllegalArgumentException
	public void setNumber(String number) throws IllegalArgumentException {
		this.setNumber(number, NumberRegex.UNSIGNED_INTEGER);
	}
	
	// Set the number with the integer value specified and the regex with the NumberRegex UNSIGNED_INTEGER
	// If the value isn't valid for this NumberRegex the method generate and IllegalArgumentException
	public void setNumber(int number) throws IllegalArgumentException {
		this.setNumber(String.valueOf(number), NumberRegex.UNSIGNED_INTEGER);
	}
	
	// Return the number as String with or without the sign according to the parameter sign
	public String getNumber(boolean sign) {
		if(sign) {
			return this.number;
		} else {
			if(this.isNegative()) {
				return this.number.substring(1);
			} else {
				return this.number;
			}
		}
	}
	
	// Return the number as String with the sign for negative numbers
	public String getNumber() {
		return this.getNumber(true);
	}
	
	// Return the value content between the specified index as integer
	// If the index are invalid or the returned value could not be allocated in an Integer
	//   the method return an IllegalArgumentException
	// The index start in 0 and don't take in count the sign for negative numbers
	// The element in the finalIndex position is not included
	public int toInt(int initialIndex, int finalIndex) throws IllegalArgumentException {
		int value = 1;
		if(this.isNegative()) {
			initialIndex++;
			finalIndex++;
			value = -1;
		}
		if(initialIndex >= 0 && initialIndex < this.length() &&
				finalIndex > initialIndex && finalIndex <= this.length()) {
			value *= Integer.parseInt(this.number.substring(initialIndex, finalIndex));
		} else {
			throw new IllegalArgumentException();
		}
		return value;
	}
	
	// Return the value content in the specified index as integer
	// If the index is invalid the method return an IllegalArgumentException
	public int toInt(int index) throws IllegalArgumentException {
		return this.toInt(index, index+1);
	}
	
	// Return the value of the complete number as integer
	// If the returned value could not be allocated in an Integer
	//   the method return an IllegalArgumentException
	public int toInt() throws IllegalArgumentException {
		return this.toInt(0, this.length());
	}
	
	// Verify if the number is negative
	public boolean isNegative() {
		return IntegerNumber.isValid(this.getNumber(), NumberRegex.NEGATIVE);
	}
	
	// Verify if the content of the number is "0"
	public boolean isNull() {
		if(this.length() == 1 && this.toInt(0) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Return the length of the number without the sign of negative numbers
	public int length() {
		if(this.isNegative()) {
			return this.number.length()-1;
		} else {
			return this.number.length();
		}
	}
	
	// Return the number as String with or without the sign according to the parameter sign
	public void addZeros(int length) throws IllegalArgumentException {
		if(length >= this.length()) {
			String zeros = "";
			String value = this.getNumber(false);
			for(int i = 0; i < length - this.length(); i++) {
				zeros += "0";
			}
			if(this.isNegative()) {
				zeros = "-" + zeros;
			}
			this.setNumber(zeros + value, this.regex);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	// Verify if the number is valid according to an specified NumberRegex
	public static boolean isValid(String number, NumberRegex regex) {
		return number.matches(regex.getRegex());
	}

}