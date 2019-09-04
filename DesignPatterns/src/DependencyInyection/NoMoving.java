package DependencyInyection;

public class NoMoving implements Moving {

    @Override
    public void move() {
        System.out.println("Nothing");
    }
    
}
