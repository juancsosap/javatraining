package P08_Methods;

public class E04_MethodScope {

	public static String var = "GLOBAL";
	
	public static void main(String[] args) {
		String var = "MAIN";
		System.out.println("FROM MAIN: " + var);
		
		scopeArg(var);
		System.out.println("FROM MAIN: " + var);
		
		scopeVar();
		System.out.println("FROM MAIN: " + var);
		
		scopeLocal();
		System.out.println("FROM MAIN: " + var);
		System.out.println("FROM MAIN (GLOBAL): " + E04_MethodScope.var);
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
	
	private static void scopeLocal() {
		System.out.println("FROM SCOPE_LOCAL METHOD: " + var);
		var = "METHOD LOCAL";
		System.out.println("FROM SCOPE_LOCAL METHOD: " + var);
	}

}
