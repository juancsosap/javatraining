package DependencyInyection;

public class Program {

    public static void main(String ... args) {
        Animal lion = new Animal("Leo", new Run(), 
                                        new Carnivoran(), 
                                        new Viviparous());
        lion.eat();
        lion.move();
        lion.sex();
        
        System.out.println();
        
        Animal whale = new Animal("Willy", new Swimm(), 
                                        new Carnivoran(), 
                                        new Viviparous());
        whale.eating.eat();
        whale.moving.move();
        whale.reproduction.sex();
    }
    
}
