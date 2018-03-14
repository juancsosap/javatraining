package DataAccessObject_DAO;

import java.util.List;

public interface IDAO<T> {
	
	// CREATE
	public void create(T data);
	
	// RETRIVE
	public T retrive(T emptyData);
	public List<T> retriveAll();

	// UPDATE
	public void update(T data);
	
	// DELETE
	public void delete(T data);
	
}
