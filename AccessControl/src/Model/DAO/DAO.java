package Model.DAO;

import java.util.List;

public interface DAO<T, K> {
    
    public T create(T obj);
    public T retrive(K key);
    public List<T> retrive();
    public T update(T obj);
    public T delete(T obj);
    
}
