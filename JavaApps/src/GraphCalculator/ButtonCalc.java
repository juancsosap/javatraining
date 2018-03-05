package GraphCalculator;

public enum ButtonCalc {
	PERCENTAGE(    "%",        ButtonType.FUNCTION, "%"),
	SQRT(          "\u221A",   ButtonType.FUNCTION, "R"),
	SQUARE(        "x\u00B2",  ButtonType.FUNCTION, "S"),
	INVERSE(       "\u00B9/x", ButtonType.FUNCTION, "I"),
	CLEAR_ALL(     "CE",       ButtonType.FUNCTION, "A"),
	CLEAR(         "C",        ButtonType.FUNCTION, "C"),
	DELETE(        "\u25C4",   ButtonType.FUNCTION, "D"),
	NEGATION(      "\u00B1",   ButtonType.FUNCTION, "N"),
	
	DIVITION(      "\u00F7",   ButtonType.OPERATOR, "/"),
	MULTIPLICATION("x",        ButtonType.OPERATOR, "*"),
	SUBSTRACTION(  "-",        ButtonType.OPERATOR, "-"),
	ADDITION(      "+",        ButtonType.OPERATOR, "+"),
	EQUAL(         "=",        ButtonType.OPERATOR, "="),
	
	NUMBER1(       "1",        ButtonType.NUMBER,   "1"),
	NUMBER2(       "2",        ButtonType.NUMBER,   "2"),
	NUMBER3(       "3",        ButtonType.NUMBER,   "3"),
	NUMBER4(       "4",        ButtonType.NUMBER,   "4"),
	NUMBER5(       "5",        ButtonType.NUMBER,   "5"),
	NUMBER6(       "6",        ButtonType.NUMBER,   "6"),
	NUMBER7(       "7",        ButtonType.NUMBER,   "7"),
	NUMBER8(       "8",        ButtonType.NUMBER,   "8"),
	NUMBER9(       "9",        ButtonType.NUMBER,   "9"),
	NUMBER0(       "0",        ButtonType.NUMBER,   "0"),
	DECIMAL(       ".",        ButtonType.NUMBER,   "."),
	
	THOUSAND(      ",",        ButtonType.NUMBER,   "~");
	
	String label;
	ButtonType type;
	String key;
	
	private ButtonCalc(String label, ButtonType type, String key) {
		this.label = label;
		this.type = type;
		this.key = key;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public ButtonType getType() {
		return this.type;
	}
	
	public String getKey() {
		return this.key;	
	}
	
	public static boolean isValid(String key) {
		return ButtonCalc.getButtonCalc(key) != null;
	}
	
	public static ButtonCalc getButtonCalc(String key) {
		for(ButtonCalc buttonCalc : ButtonCalc.values()) {
			if(buttonCalc.getKey().equalsIgnoreCase(key)) {
				return buttonCalc;
			}
		}
		return null;
	}
	
	public String toString() {
		return this.getLabel();
	}
	
}

enum ButtonType { NUMBER, OPERATOR, FUNCTION }
