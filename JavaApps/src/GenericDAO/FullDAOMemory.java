package GenericDAO;

import java.util.List;

public class FullDAOMemory<T extends Gettable<K> & Updatable<T>, K> extends DAOMemory<T, K> 
                                                                       implements FullDAO<T, K> {
	
	@Override
	public List<T> retrive(int offset, int limit) {
		return this.db.get(offset, limit);
	}

	@Override
	public List<T> retrive() {
		return this.db.get(0, Integer.MAX_VALUE);
	}

	@Override
	public List<T> delete() {
		List<T> dObjs = retrive();
		for(T obj : dObjs) {
			delete(obj.get());
		}
		return dObjs;
	}

}
