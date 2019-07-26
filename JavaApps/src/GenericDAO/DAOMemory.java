package GenericDAO;

import java.util.ArrayList;
import java.util.List;

public class DAOMemory<T extends Gettable<K> & Updatable<T>, K> extends BasicDAOMemory<T, K> 
                                                                implements DAO<T, K> {
	@Override
	public List<T> create(List<T> objs) {
		List<T> cObjs = new ArrayList<>();
		for(T obj : objs) {
			cObjs.add(create(obj));
		}
		return cObjs;
	}

	@Override
	public List<T> retrive(List<K> ids) {
		List<T> rObjs = new ArrayList<>();
		for(K id : ids) {
			T obj = retrive(id);
			if(obj != null)
				rObjs.add(obj);
		}
		return rObjs;
	}
	
	@Override
	public List<T> update(List<T> objs) {
		List<T> uObjs = new ArrayList<>();
		for(T obj : objs) {
			uObjs.add(update(obj));
		}
		return uObjs;
	}

	@Override
	public List<T> delete(List<K> ids) {
		List<T> dObjs = new ArrayList<>();
		for(K id : ids) {
			T obj = delete(id);
			if(obj != null)
				dObjs.add(obj);
		}
		return dObjs;
	}

}
