package GenericDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryDB<T extends Gettable<K> & Updatable<T>, K> {
	
	public MemoryDB(Runnable initial) {
		initial.run();
	}
	public MemoryDB() {
		this(() -> {});
	}
	
	private List<T> objs = new ArrayList<>();
	
	public T add(T obj) {
		this.objs.add(obj);
		return obj;
	}
	
	public List<T> get(int offset, int limit) {
		return this.objs.stream()
				        .skip(offset).limit(limit)
				        .collect(Collectors.toList());
	}
	
	public T get(K id) {
		return this.objs.stream()
				        .filter(o -> o.get() == id)
				        .findFirst().orElse(null);
	}
	
	public T change(T obj) {
		T oldObj = get(obj.get());
		return oldObj.update(obj);
	}
	
	public T del(K id) {
		T obj = get(id);
		if(obj != null)
			this.objs.remove(obj);
		return obj;
	}
	
	public int size() {
		return this.objs.size();
	}

}
