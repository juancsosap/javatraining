package ranger;

public class App {

    public static void main(String[] args) {
        Generator gen = new SecuentialGenerator();
        Printer p = new VPrinter();
        Ranger r = new Ranger(p, gen);
        r.print(4, 9);
    }
    
}
