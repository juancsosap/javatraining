package GraphCalculator;

import java.awt.Color;

public enum ColorCalculator {
	
	UP_NUMBER(    new Color(255, 255, 255)), 
	OVER_NUMBER(  new Color(213, 213, 213)),
	DOWN_NUMBER(  new Color(190, 190, 190)),
	
	UP_OPERATOR(  new Color(240, 240, 240)),
	OVER_OPERATOR(new Color(135, 166, 248)),
	DOWN_OPERATOR(    new Color(139, 228, 254)),
	
	UP_FUNCTION(  new Color(240, 240, 240)),
	OVER_FUNCTION(new Color(213, 213, 213)),
	DOWN_FUNCTION(new Color(190, 190, 190)),
	
	BACKGROUND(   new Color(235, 235, 235));
	
	Color color;
	
	private ColorCalculator(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

}

enum ButtonMouseState { UP, OVER, DOWN }
