package ranger;

import java.io.PrintStream;

public class StreamPrinter implements Printer {

    private PrintStream stream;
    
    public StreamPrinter(PrintStream stream) {
        this.stream = stream;
    }
    
    @Override
    public void print(int[] data) {
        for(int i : data) {
            this.stream.println(i);
        }
    }
    
}
