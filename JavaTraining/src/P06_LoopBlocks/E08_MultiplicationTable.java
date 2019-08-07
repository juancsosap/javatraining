package P06_LoopBlocks;

public class E08_MultiplicationTable {

	public static void main(String[] args) {
		get(5);
	}
	
	public static void get(int number) {
		int i = 1, j = 1;
		do {
			System.out.println(i + " * " + j + " = " + (i*j));
			j++;
			if(j <= number) continue;
			j = 1;
			i++;
			System.out.println();
			continue; // --> Each continue validate the condition before go to the top
		} while(i < number);
	}

}
