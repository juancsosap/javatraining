package modules.maths.internal;

import modules.maths.Operation;
import modules.maths.Operator;

public class NullOperator implements Operator {

	public double operate(double n1, double n2) {
		return 0;
	}

	public Operation name() {
		return Operation.NULL;
	}

}
