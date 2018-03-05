package BasicPooShape;

import java.awt.Color;

public enum ShapeColor {
	DARK(new Color(12,2,123)),
	LIGTH(Color.CYAN),
	NORMAL(Color.GREEN);
	
	private Color color;
	
	private ShapeColor(Color value) {
		this.color = value;
	}
	
	public Color getColor() {
		return this.color;
	}
}

enum ShapeColor2 { DARK, LIGTH, NORMAL }

