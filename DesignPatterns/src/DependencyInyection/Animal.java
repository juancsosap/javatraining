package DependencyInyection;

public class Animal {
    
    public String name;
    
    public Moving moving;
    public Eating eating;
    public Reproduction reproduction;
    
    public Animal(String name, Moving moving, 
                  Eating eating, Reproduction reproduction) {
        this.name = name;
        this.moving = moving;
        this.eating = eating;
        this.reproduction = reproduction;
    }
    
    public void move() {
        this.moving.move();
    }
    
    public void eat() {
        this.eating.eat();
    }
    
    public void sex() {
        this.reproduction.sex();
    }
    
}
