package DependencyInyection;

public class Vegetarian implements Eating {

    @Override
    public void eat() {
        System.out.println("Eating Vegetables");
    }
    
}
