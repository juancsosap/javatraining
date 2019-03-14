package Model;

public class Zone {
    
    private final int id;
    private String name;
    
    public Zone(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Zone(String name) { this(0, name); }
    public Zone(Zone zone) { this(zone.getId(), zone.getName()); }
    
    public void changeName(String name) {
        this.name = name;
    }
    
    public int getId() { return this.id; }
    public String getName() { return this.name; }
    
}
