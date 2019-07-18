package ranger;

public class Ranger {
    
    private Printer printer;
    private Generator gen;
    
    public Ranger(Printer printer, Generator gen) {
        this.printer = printer;
        this.gen = gen;
    }
    
    public void print(int ini, int end) {
        int[] data = this.get(ini, end);
        this.printer.print(data);
    }
    
    public int[] get(int ini, int end) {
        int size = end - ini;
        int[] data = new int[size];
        int j = 0;
        for(int i=0; i<end; i++) {
            int value = this.gen.getNext();
            if(i >= ini) {
                data[j++] = value;
            }
        }
        return data;
    }
    
}
