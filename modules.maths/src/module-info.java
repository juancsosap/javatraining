module mod.maths {
	requires java.base;
	exports modules.maths;
	
	uses modules.maths.Operator;
	provides modules.maths.Operator
	  with modules.maths.internal.AdditionOperator, 
	       modules.maths.internal.SubtractionOperator,
	       modules.maths.internal.MultiplicationOperator,
	       modules.maths.internal.DivisionOperator,
	       modules.maths.internal.ModulusOperator,
	       modules.maths.internal.NullOperator;
}