package MethodFactory_TemplateMethod;

public interface ShapeFactory {
	
	public static final ShapeType[] SHAPES = ShapeType.values();
	
	public default IShape make() {
		ShapeType shape = choose(); 
		switch(shape) {
			case CIRCLE: return new Circle();
			case SQUARE: return new Square();
			case RECTANGLE: return new Rectangle();
			default: return null;
		}
	}
	
	public ShapeType choose();

}
