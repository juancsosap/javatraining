package Model;

import java.time.LocalDateTime;

public class Track {

    private final Person person;
    private final Zone zone;
    private final LocalDateTime ingress;
    private LocalDateTime egress;
    
    public Track(Person person, Zone zone) {
        this.person = new Person(person);
        this.zone = new Zone(zone);
        this.ingress = LocalDateTime.now();
        this.egress = null;
    }
    
    public void egressZone() {
        this.egress = LocalDateTime.now();
    }
    
    public Person getPerson() { return new Person(this.person); }
    public Zone getZone() { return new Zone(this.zone); }
    public LocalDateTime getIngressTime() { return this.ingress; }
    public LocalDateTime getEgressTime() { return this.egress; }
    
}
