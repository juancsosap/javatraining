package GenericDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryDBList {
	
	public MemoryDBList(Runnable initial) {
		initial.run();
	}
	public MemoryDBList() {
		this(() -> {});
	}
	
	private List<List<Object>> table = new ArrayList<>();
	
	public void add(List<Object> record) {
		this.table.add(record);
	}
	
	public List<List<Object>> get(int offset, int limit) {
		return this.table.stream()
				        .skip(offset).limit(limit)
				        .collect(Collectors.toList());
	}
	
	public List<Object> get(Object id) {
		return this.table.stream()
				        .filter(o -> o.get(0) == id)
				        .findFirst().orElse(null);
	}
	
	public List<Object> change(List<Object> record) {
		int index = this.table.indexOf(get(record.get(0)));
		if(index > -1) {
			record.set(index, record);
			return record;
		}
		return null;
	}
	
	public List<Object> del(Object id) {
		List<Object> record = get(id);
		if(record != null)
			this.table.remove(record);
		return record;
	}
	
	public int size() {
		return this.table.size();
	}

}
