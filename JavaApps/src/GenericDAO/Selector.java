package GenericDAO;

import java.util.HashMap;
import java.util.Map;

public abstract class Selector {

	protected Map<Integer, Integer> selector = new HashMap<>();
    
    public int get(Integer field) {
    	return this.selector.getOrDefault(field, 0);
    }
    
    public int size() {
    	return selector.size();
    }
 
}