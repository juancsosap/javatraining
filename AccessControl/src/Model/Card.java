package Model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Card {

    private final int id;
    private Person person;
    private boolean active;
    private final ArrayList<Zone> zones;
    
    public Card(int id, Person person, boolean active, ArrayList<Zone> zones) {
        this.id = id;
        this.person = new Person(person);
        this.active = active;
        this.zones = (ArrayList<Zone>) zones.clone();
    }
    public Card(int id) { this(id, null, false, new ArrayList<>()); }
    
    public void setPerson(Person person) {
        this.person = new Person(person);
    }
    
    public void activate() throws NotAllowedActionException {
        if(person != null) {
            if(!this.active) {
                this.active = true;
            } else {
                throw new NotAllowedActionException("The Card is already active");
            }
        } else {
            throw new NotAllowedActionException("Could not be activate a card that is not assigned to a person");
        }
    }
    
    public void deactivate() throws NotAllowedActionException {
        if(this.active) {
            this.active = false;
        } else {
            throw new NotAllowedActionException("The Card isn't active");
        }
    }
    
    public void addZone(Zone zone) throws NotAllowedActionException {
        if(!this.zones.contains(zone)) {
            this.zones.add(zone);
        } else {
            throw new NotAllowedActionException("The zone was already assigned");
        }
    }
    
    public void delZone(Zone zone) throws NotAllowedActionException {
        if(this.zones.contains(zone)) {
            this.zones.remove(zone);
        } else {
            throw new NotAllowedActionException("The zone wasn't assigned");
        }
    }
    
    public int getId() { return this.id; }
    public Person getPerson() { return new Person(this.person); }
    public boolean isActive() { return this.active; }
    public List<Zone> getZones() { return (List<Zone>) this.zones.clone(); }
    
    @SuppressWarnings("serial")
	public static class NotAllowedActionException extends RuntimeException {
        
        public NotAllowedActionException(String name) {
            super(name);
        }
        
    }
    
}
