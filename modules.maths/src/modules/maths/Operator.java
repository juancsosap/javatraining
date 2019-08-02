package modules.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

//import modules.maths.internal.*;

public interface Operator {
	
	public double operate(double n1, double n2);
	
	public Operation name();
	/*
	public static Operator get(Operation oper) {
		switch(oper) {
			case ADDITION: return new AdditionOperator();
			case SUBTRACTION: return new SubtractionOperator();
			case MULTIPLICATION: return new MultiplicationOperator();
			case DIVISION: return DivisionOperator();
			case MODULUS: return ModulusOperator();
			default: return NullOperator();
		}
	}
	*/
	public static List<Operator> get() {
		var services = ServiceLoader.load(Operator.class);
	    var operators = new ArrayList<Operator>();
	    services.iterator().forEachRemaining(operators::add);
	    return operators;
	}
	
}
