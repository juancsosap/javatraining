package GenericDAO;

public class BasicDAOMemory<T extends Gettable<K> & Updatable<T>, K> implements BasicDAO<T, K> {

	protected final MemoryDB<T, K> db = new MemoryDB<>();
	
	@Override
	public T create(T obj) {
		return this.db.add(obj);
	}
	
	@Override
	public T retrive(K id) {
		return this.db.get(id);
	}

	@Override
	public T update(T obj) {
		return this.db.change(obj);
	}

	@Override
	public T delete(K id) {
		return this.db.del(id);
	}

}
