package ranger;

public class SecuentialGenerator extends Generator {

    public SecuentialGenerator() {
        super(0);
    }
    
    @Override
    public int getNext() {
        return ++this.previous;
    }
    
}
