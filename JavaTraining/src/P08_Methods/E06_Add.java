package P08_Methods;

public class E06_Add {

	public static void main(String[] args) {
		
		System.out.println(add(5, 2));
		System.out.println(add(5));
		System.out.println(add(5, 2, 7));
		
		int[] n1 = {1, 2, 3, 4, 5};
		System.out.println(add(n1));

		System.out.println(addf(5, 2));
		System.out.println(addf(5));
		System.out.println(addf(5, 2, 7));
		
		System.out.println(addf(7, n1));

		System.out.println(addf(n1, 7));

	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	public static int add(int a) { 
		return add(a, 0);
	}
	public static int add(int ... nums) {
		int result = 0;
		for(int num : nums) {
			result += num;
		}
		return result;
	}
	
	public static int addf(int factor, int ... nums) {
		int result = 0;
		for(int num : nums) {
			result += num;
		}
		return result * factor;
	}
	
	public static int addf(int[] nums, int factor) {
		return addf(factor, nums);
	}

}
