package GenericDAO;

public interface BasicDAOList<T, K> {

	public boolean create(T obj);
	
	public boolean retrive(K id, T obj);
	
	public boolean update(K id, T obj);
	
	public boolean delete(T obj);
	
}
