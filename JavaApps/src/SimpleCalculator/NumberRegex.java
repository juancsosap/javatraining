package SimpleCalculator;

public enum NumberRegex {
	UNSIGNED_INTEGER("^[0-9]+$"),
	UNSIGNED_INTEGER_NOT_NULL("^[0]*[1-9]+[0-9]*$"), 
	SIGNED_INTEGER("^-?[0-9]+$"),
	SIGNED_INTEGER_NOT_NULL("^-?[0]*[1-9]+[0-9]*$"),
	UNSIGNED_FLOAT("^[0-9]+(\\.[0-9]+)?$"),
	SIGNED_FLOAT("^-?[0-9]+(\\.[0-9]+)?$"),
	NEGATIVE("^-.+$");
	
	private String regex;
	
	private NumberRegex(String regex) { 
		this.regex = regex;
	}
	
	public String getRegex() {
		return this.regex;
	}
	
}