package modules.maths.internal;

import modules.maths.Operation;
import modules.maths.Operator;

public class DivisionOperator implements Operator {

	public double operate(double n1, double n2) {
		return n1 / n2;
	}

	public Operation name() {
		return Operation.DIVISION;
	}

}
