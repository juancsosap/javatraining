package program;

import modules.maths.*;
// import modules.maths.internal.*;

public class Program {

	public static void main(String[] args) {
		/*
		Operator oper;
		
		oper = Operator.get(Operation.ADDITION);
		// oper = new AdditionOperator();
		System.out.println("ADD: " + oper.operate(5, 5));
		
		oper = Operator.get(Operation.SUBTRACTION);
		// oper = new SubtractionOperator();
		System.out.println("SUB: " + oper.operate(5, 5));
		
		oper = Operator.get(Operation.MULTIPLICATION);
		// oper = new MultiplicationOperator();
		System.out.println("MUL: " + oper.operate(5, 5));
		
		oper = Operator.get(Operation.DIVISION);
		// oper = new DivisionOperator();
		System.out.println("DIV: " + oper.operate(5, 5));
		
		oper = Operator.get(Operation.MODULUS);
		// oper = new ModulusOperator();
		System.out.println("MOD: " + oper.operate(5, 5));
		
		oper = Operator.get(Operation.NULL);
		// oper = new NullOperator();
		System.out.println("NULL: " + oper.operate(5, 5));
		
		System.out.println();
		*/
		Operator.get().stream()
				.forEach(o -> {
					System.out.println(o.getClass().getName());
					System.out.println(o.name() + ": " + o.operate(5,7));
				});
		
	}
	
}
