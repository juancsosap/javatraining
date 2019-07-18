package Easy;

import java.util.Scanner;

public class JavaSubarray {

	public static void main(String[] args) {
		
		try(Scanner console = new Scanner(System.in)) {
		
			int size = Integer.parseInt(console.nextLine());
			
			String[] numbers_str = console.nextLine().split("[ ]");
			
			int[] numbers_int = new int[size];
			for(int i=0; i<size; i++) {
				numbers_int[i] = Integer.parseInt(numbers_str[i]);
			}
			
			int count = 0;
			for(int k=0; k<size; k++) {
				for(int i=k+1; i<=size; i++) {
					int sum = 0;
					for(int j=k; j<i; j++) {
						sum += numbers_int[j];
					}
					if(sum < 0)
						count++;
				}
			}
			System.out.println(count);
			
		}
		
	}

}
