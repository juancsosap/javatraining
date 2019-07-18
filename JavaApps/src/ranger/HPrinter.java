package ranger;

public class HPrinter implements Printer {

    @Override
    public void print(int[] data) {
        for(int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
}
