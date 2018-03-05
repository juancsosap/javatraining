package P08_Methods;

public class E04_MethodScope {

	public static void main(String[] args) {
		String var = "MAIN";
		System.out.println("FROM MAIN: " + var);
		
		scopeArg(var);
		System.out.println("FROM MAIN: " + var);
		
		scopeVar();
		System.out.println("FROM MAIN: " + var);
	}
	
	private static void scopeArg(String var) {
		System.out.println("FROM SCOPE_ARG METHOD: " + var);
		var = "METHOD_ARG";
		System.out.println("FROM SCOPE_ARG METHOD: " + var);
	}
	
	private static void scopeVar() {
		String var = "METHOD_VAR";
		System.out.println("FROM SCOPE_VAR METHOD: " + var);
	}

}
