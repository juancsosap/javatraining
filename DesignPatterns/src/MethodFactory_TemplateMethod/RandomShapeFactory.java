package MethodFactory_TemplateMethod;

import java.util.Random;

public class RandomShapeFactory implements ShapeFactory {
	
	public ShapeType choose() {
		Random generator = new Random();
		int randomIndex = generator.nextInt(RandomShapeFactory.SHAPES.length);
		return RandomShapeFactory.SHAPES[randomIndex];
	}

}
