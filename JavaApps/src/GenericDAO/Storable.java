package GenericDAO;

public interface Storable<T, K> extends Gettable<K>, 
                                        Updatable<T>, 
                                        Listable, 
                                        Selectable {}
