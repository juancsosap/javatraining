package GenericDAO;

import java.util.List;

public interface DAO<T, K> extends BasicDAO<T, K> {
	
	public List<T> create(List<T> objs);
	
	public List<T> retrive(List<K> ids);
	
	public List<T> update(List<T> objs);
	
	public List<T> delete(List<K> ids);

}
