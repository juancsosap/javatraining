package DataAccessObject_DAO;

import java.util.ArrayList;
import java.util.List;

public class MemoryDAO<T> implements IDAO<T> {

	List<T> store = new ArrayList<>();
	
	@Override
	public void create(T data) {
		if(!store.contains(data))
			store.add(data);
	}

	@Override
	public T retrive(T emptyData) {
		if(store.contains(emptyData))
			return store.get(store.indexOf(emptyData));
		return null;
	}

	@Override
	public List<T> retriveAll() {
		return store;
	}

	@Override
	public void update(T data) {
		if(store.contains(data))
			store.set(store.indexOf(data), data);
	}

	@Override
	public void delete(T data) {
		if(store.contains(data))
			store.remove(data);
	}

}
