package GenericDAO;

public interface BasicDAO<T, K> {

	public T create(T obj);
	
	public T retrive(K id);
	
	public T update(T obj);
	
	public T delete(K id);
	
}
