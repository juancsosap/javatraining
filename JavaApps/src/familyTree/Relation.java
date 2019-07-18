package familyTree;

public class Relation {
	private RelType type;
	private Person target;
	
	public Relation(RelType type, Person target) {
		this.type = type;
		this.target = target;
	}
	
	public RelType getType() {
		return this.type;
	}
	
	public Person getTarget() {
		return this.target;
	}
}
