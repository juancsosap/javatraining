package ballsTable;

public class MainBallTable {

	public static void main(String[] args) {
		
		Table myTable = new Table(1000, 600);
		for(int i=0; i<100; i++) {
			myTable.addBall();
		}
		
	}

}
