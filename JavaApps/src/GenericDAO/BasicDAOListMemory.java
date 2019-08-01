package GenericDAO;

import java.util.List;

public class BasicDAOListMemory<T extends Storable<T, K>, K> 
                                  implements BasicDAOList<T, K> {

	protected final MemoryDBList db = new MemoryDBList();
	
	@Override
	public boolean create(T obj) {
		this.db.add(obj.toList());
		return true;
	}
	
	@Override
	public boolean retrive(K id, T obj) {
		List<Object> rObj = this.db.get(id);
		obj.fromList(rObj);
		return rObj != null;
	}

	@Override
	public boolean update(K id, T obj) {
		if(this.db.get(id) == null)
			return false;
		this.db.change(obj.toList());
		return true;
	}

	@Override
	public boolean delete(T obj) {
		if(this.db.get(obj.get()) == null)
			return false;
		this.db.del(obj.get());
		return true;
	}

}
