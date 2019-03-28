package ranger;

public abstract class Generator {
    
    protected int previous;
    
    public Generator(int seed) {
        this.previous = seed;
    }
    
    public int get() {
        return this.previous;
    }
    
    public abstract int getNext();
    
}
