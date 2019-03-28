package ranger;

public class MultipleGenerator extends Generator {

    private int factor;
    
    public MultipleGenerator(int factor) {
        super(0);
        this.factor = factor;
    }
    
    @Override
    public int getNext() {
        this.previous += this.factor;
        return this.previous;
    }
    
}
