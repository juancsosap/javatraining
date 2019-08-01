package GenericDAO;

import java.util.List;

public interface Listable {

	public List<Object> toList();
	
	public void fromList(List<Object> record);
	
}
