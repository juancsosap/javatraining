package ranger;

public class EvenGenerator extends Generator {

    public EvenGenerator() {
        super(0);
    }
    
    @Override
    public int getNext() {
        this.previous += 2;
        return this.previous;
    }
    
}
