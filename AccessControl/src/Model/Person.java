package Model;

public class Person {

    private final int id;
    private final String name;
    private String role;
    
    public Person(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    public Person(String name, String role) { this(0, name, role); }
    public Person(Person person) { this(person.getId(), person.getName(), person.getRole()); }
    
    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public String getRole() { return this.role; }
    
    public void setRole(String role) {
        this.role = role;
    }
    
}
