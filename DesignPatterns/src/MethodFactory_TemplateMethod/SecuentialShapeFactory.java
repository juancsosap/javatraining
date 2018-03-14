package MethodFactory_TemplateMethod;

public class SecuentialShapeFactory implements ShapeFactory {

	private ShapeType lastShape = ShapeType.RECTANGLE;
	
	@Override
	public ShapeType choose() {
		int newIndex = (lastShape.ordinal() + 1) % ShapeFactory.SHAPES.length;
		lastShape = ShapeFactory.SHAPES[newIndex];
		return lastShape;
	}

}
