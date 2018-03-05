package basic;

public class MatrixAdder {

	public static void main(String[] args) {
		
		/*
		int[][] matrix1 = {{1,2,3}, 
                           {4,7,6},
                           {7,8,9}};
		
		for(int[] fila : matrix1) {
			for(int valor : fila) {
				System.out.print(valor + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		int[][] matrix2 = {{9,8,7}, 
                           {6,5,4},
                           {3,2,1}};
		
		for(int[] fila : matrix2) {
			for(int valor : fila) {
				System.out.print(valor + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		int[][] matrix3 = new int[3][3];
		
		for(int f = 0; f < matrix1.length; f++) {
			for(int c = 0; c < matrix1[f].length; c++) {
				matrix3[f][c] = matrix1[f][c] + matrix2[f][c];
				System.out.print(matrix3[f][c] + "\t");
			}
			System.out.println();
		}
		
		
		 *  10 10 10
		 *  10 10 10
		 *  10 10 10
		 *  
		 */
		
		int[][] matrix1 = {{1,2,3,1},{4,7,6,1},{7,8,9,1}};
		int[][] matrix2 = {{1,2,3,1},{4,7,6,1},{7,8,9,1}};
		
		Matrix m1 = new Matrix(matrix1);
		m1.print();
		Matrix m2 = new Matrix(matrix2);
		m2.print();
		Matrix m3 = Matrix.add(m1, m2);
		m3.print();

	}

}

class Matrix {
	int[][] matrix;
	int rows;
	int columns;
	
	Matrix(int[][] mIn) {
		rows = mIn.length;
		columns = mIn[0].length;
		matrix = mIn;
	}
	
	void print() {
		for(int[] fila : matrix) {
			for(int valor : fila) {
				System.out.print(valor + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static Matrix add(Matrix m1, Matrix m2) {
		int[][] matrix1 = m1.matrix;
		int[][] matrix2 = m2.matrix;
		int rs = matrix1.length;
		int cs = matrix1[0].length;
		int[][] matrix3 = new int[rs][cs];
		for(int f = 0; f < matrix1.length; f++) {
			for(int c = 0; c < matrix1[f].length; c++) {
				matrix3[f][c] = matrix1[f][c] + matrix2[f][c];
			}
		}
		return new Matrix(matrix3);
	}
}
