package ranger;

public class VPrinter implements Printer {

    @Override
    public void print(int[] data) {
        for(int i : data) {
            System.out.println(i);
        }
    }
    
}
