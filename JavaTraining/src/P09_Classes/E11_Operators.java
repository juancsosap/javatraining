package P09_Classes;

public class E11_Operators {

    public static void main(String[] args) {
        
        Operator o;
        
        o = new Adder();
        o.operate(5, 5);
        o.print();
        
        Adder a = new Adder();
        a.add(7, 7);
        a.operate(1, 2, 3, 4, 5);
        a.print();
        
        o = new Subtracter();
        o.operate(5, 5);
        o.print();
        
        o = new Multiplier();
        o.operate(5, 5);
        o.print();
        
        o = new Divider();
        o.operate(5, 5);
        o.print();
        
    }
    
}

abstract class Operator {
    
    private String name;
    protected int result;
    
    public Operator(String name) {
        this.name = name;
    }
    
    public abstract void operate(int d1, int d2);
    
    public void print() {
        System.out.println(this.name + " : " + this.result);
    }
}

class Adder extends Operator {
    
    public Adder() {
        super("Add");
    }
    
    @Override
    public void operate(int d1, int d2) {
        this.result = d1 + d2;
    }
    
    public void operate(int ... data) {
        int result = 0;
        for(int d : data) {
            result += d;
        }
        this.result = result;
    }
    
    public void add(int d1, int d2) {
        this.operate(d1, d2);
        this.print();
    }
    
}

class Subtracter extends Operator {
    
    public Subtracter() {
        super("Sub");
    }
    
    @Override
    public void operate(int d1, int d2) {
        this.result = d1 - d2;
    }
    
}

class Multiplier extends Operator {
    
    public Multiplier() {
        super("Mul");
    }
    
    @Override
    public void operate(int d1, int d2) {
        this.result = d1 * d2;
    }
    
}

class Divider extends Operator {
    
    public Divider() {
        super("Div");
    }
    
    @Override
    public void operate(int d1, int d2) {
        this.result = d1 / d2;
    }
    
}