package familyTree;

import java.util.HashSet;
import java.util.Set;

import GenericDAO.*;

public class Person implements Gettable<Integer>, Updatable<Person> {
	private int id;
    private String name;
    private Gender gender;
    private Set<Relation> relations = new HashSet<>();
    
    private static int lastID = 0;
    
    public Person(int id, String name, Gender gender) {
    	this.id = id;
        this.name = name;
        this.gender = gender;
    }
    
    public Person(String name, Gender gender) {
    	this(++lastID, name, gender);
    }

    public int getID() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Gender getGender() {
    	return this.gender;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setGender(Gender gender) {
    	this.gender = gender;
    }
    
    public void addRelations(RelType myType, RelType yourType, Person target) {
    	this.addRelation(yourType, target);
    	target.addRelation(myType, this);
    }

    public void addRelations(RelType type, Person target) {
    	this.addRelations(type, type, target);
    }
    
    public void addRelation(RelType type, Person target) {
    	this.relations.add(new Relation(type, target));
    }

    public void addParents(Person ... parents) {
    	for(Person parent : parents) {
    		this.addParent(parent);
    	}
    }
    
    public void addParent(Person parent) {
    	parent.addRelations(RelType.PARENT, RelType.CHILD, this);
    }
    
    public People getSiblings() {
    	People people = new People();
    	this.getType(RelType.PARENT).stream()
    	                            .flatMap(p -> p.getType(RelType.CHILD).stream())
    						   		.filter(p -> !p.equals(this))
    						   		.forEach(p -> people.add(p));
    	return people;
    }
    
    public People getType(RelType type) {
    	People people = new People();
    	this.relations.stream()
    	              .filter(r -> r.getType() == type)
    				  .map(r -> r.getTarget())
    				  .forEach(p -> people.add(p));
    	return people;
    }
    
    @Override
    public String toString() {
    	return String.format("%s (%s)",this.name, this.gender);
    }

	@Override
	public Person update(Person obj) {
		this.setName(obj.getName());
		this.setGender(obj.getGender());
		return this;
	}

	@Override
	public Integer get() {
		return getID();
	}

}