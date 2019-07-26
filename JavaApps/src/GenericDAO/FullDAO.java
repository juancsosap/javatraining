package GenericDAO;

import java.util.List;

public interface FullDAO<T, K> extends DAO<T, K> {

	public List<T> retrive(int offset, int limit);
	public List<T> retrive();
	
	public List<T> delete();
	
}
