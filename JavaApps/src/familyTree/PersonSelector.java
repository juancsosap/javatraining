package familyTree;

import GenericDAO.Selector;

public class PersonSelector extends Selector {

    public PersonSelector(int id, int name, int gender) {
    	this.selector.put(1, id);
    	this.selector.put(2, name);
    	this.selector.put(3, gender);
    }
    
}