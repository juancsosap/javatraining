package MethodFactory_TemplateMethod;

import java.util.Random;

public class BalanceShapeFactory implements ShapeFactory {

	@SuppressWarnings("unused")
	private int[] shapes = new int[ShapeFactory.SHAPES.length];
	
	@Override
	public ShapeType choose() {
		// Stream shapesStream = Stream.of(shapes).reduce(Integer::min);
		Random generator = new Random();
		int randomIndex = generator.nextInt(RandomShapeFactory.SHAPES.length);
		
		return RandomShapeFactory.SHAPES[randomIndex];
	}

}
