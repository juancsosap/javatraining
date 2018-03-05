package P07_Arrays;

public class E03_MatrixEvenOdd {

	public static void main(String[] args) {
		
		int[][] matrixIn = { {1, 2, 3, 4, 5}, 
				             {4, 5, 6, 7, 8}, 
				             {7, 8, 9, 0, 1} }; 
		
		System.out.print("     Matriz de Entrada");
		int rowIndex = 0;
		for(int[] row : matrixIn) {
        	System.out.println();
        	System.out.print(rowIndex++ + " -> ");
        	for(int value : row)
        		System.out.print(value + "   ");
        }
		System.out.print("\n     ^   ^   ^   ^   ^");
		System.out.print("\n     0   1   2   3   4\n\n");
		
		
		int[][] matrixOut = new int[3][5];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				matrixOut[i][j] = (matrixIn[i][j] %2 == 0) ? 0 : 1;
			}
		}
		

        System.out.print("     Matriz de Salida");
		rowIndex = 0;
		for(int[] row : matrixOut) {
        	System.out.println();
        	System.out.print(rowIndex++ + " -> ");
        	for(int value : row)
        		System.out.print(value + "   ");
        }
		System.out.print("\n     ^   ^   ^   ^   ^");
		System.out.print("\n     0   1   2   3   4\n");
		
		
	}

}
