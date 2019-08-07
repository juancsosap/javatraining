package P12_Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class E00_CollectionInterfaces {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		
		/*
		 * Iterable(I) <- Collection(I) <- List(I)  <- ArrayList(C)
		 *                                          <- LinkedList(C)
		 *                              <- Set(I)   <- HashSet(C)       <- LinkedHashSet(C)
		 *                                          <- SortedSet(I)     <- NavigableSet(I)  <- TreeSet(C)
		 *                              <- Queue(I) <- Deque(I)         <- BlockingDeque(I) <- LinkedBlockingDeque(C)
		 *                                          <- TransferQueue(I) <- LinkedTransferQueue(C)
		 *                                          <- BlockingQueue(I) <- ArrayBlockingQueue(C)
		 *                                                              <- LinkedBlockingQueue(C)
		 *                                                              
		 *                                 Map(I)   <- HashMap(C)       <- LinkedHashMap(C)
		 *                                          <- SortedMap(I)     <- NavigableMap(I)  <- TreeMap(C) 
		 * 
		 * 
		 * RandomAccess(I) <- ArrayList, Vector, Stack
		 * Cloneable(I), Serializable(I) <- All Collection Implementations
		 * 
		 */
			
		class AdapterCollection implements Collection {
			public boolean add(Object e) { return false; }
			public boolean addAll(Collection c) { return false; }
			
			public boolean remove(Object o) { return false; }
			public boolean removeAll(Collection c) { return false; }
			public void clear() {}
			public boolean retainAll(Collection c) { return false; }
			
			public boolean contains(Object o) { return false; }
			public boolean containsAll(Collection c) { return false; }
			
			public int size() { return 0; }
			public boolean isEmpty() { return false; }
			
			public Object[] toArray() { return null; }
			public Object[] toArray(Object[] a) { return null; }
			
			public Iterator iterator() { return null; }
		}
		
		class AdapterList extends AdapterCollection implements List {
			public void add(int index, Object element) {}
			public boolean addAll(int index, Collection c) { return false; }
			
			public Object get(int index) { return null; }
			
			public Object set(int index, Object element) { return null; }
			
			public Object remove(int index) { return null; }
			
			public int indexOf(Object o) { return 0; }
			public int lastIndexOf(Object o) { return 0; }
			
			public ListIterator listIterator() { return null; }
			public ListIterator listIterator(int index) { return null; }
			public List subList(int fromIndex, int toIndex) { return null; }	
		}
		
		List list1 = new ArrayList();
		List list2 = new LinkedList();
		
		class AdapterSet extends AdapterCollection implements Set {}
		
		Set set1 = new HashSet();
		Set set2 = new LinkedHashSet();
		Set set3 = new TreeSet();
		
		class AdapterQueue extends AdapterCollection implements Queue {
			public boolean offer(Object e) { return false; }
			public Object remove() { return null; }
			public Object poll() { return null; }
			public Object element() { return null; }
			public Object peek() { return null; }
		}
		
		Queue queue1 = new ArrayDeque();
		Queue queue2 = new LinkedBlockingDeque();
		Queue queue3 = new LinkedTransferQueue();
		Queue queue4 = new LinkedBlockingQueue();
		Queue queue5 = new ArrayBlockingQueue(0);
		
		class AdapterMap implements Map {
			public int size() { return 0; }
			public boolean isEmpty() { return false; }
			
			public boolean containsKey(Object key) { return false; }
			public boolean containsValue(Object value) { return false; }
			
			public Object get(Object key) { return null; }
			
			public Object put(Object key, Object value) { return null; }
			public void putAll(Map m) { }
			
			public Set keySet() { return null; }
			public Set entrySet() { return null; }
			public Collection values() { return null; }
			
			public Object remove(Object key) { return null; }
			public void clear() { }
		}
		
		Map map1 = new HashMap();
		Map map2 = new LinkedHashMap();
		Map map3 = new TreeMap();
		
	}

}
