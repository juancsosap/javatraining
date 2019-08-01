package netec.oca.getstarted;

import java.util.ArrayList;
import java.util.Collections;

public class InterfacesExamples {

    @SuppressWarnings("unused")
	public static void main(String[] args) {
        
        //Box<String> d1 = new Box<>("1");
        
        //System.out.println(d1.getDato());
        
        Map<String, Integer> l1 = new Map<>("address", 12345);
        
        System.out.println(l1.getValue("casa"));
        
        System.out.println(l1.getValue("address"));
        
        Box<Dato> b1 = new Box<>(new Dato("Hola"));
        Box<Clave> b2 = new Box<>(new Clave("Hola"));
        
        System.out.println(b1.getDato());
        
        Dato dh = b1.getDato();
        
        dh.setDato("Chao");
        
        System.out.println(b1.getDato());
        
        ArrayList<Dato> a1 = new ArrayList<>();
        
        a1.add(new Dato("123"));
        a1.add(new Dato("321"));
        a1.add(new Dato("111"));
        a1.add(new Dato("222"));
        a1.add(new Dato("131"));
        a1.add(new Dato("333"));
        
        System.out.println(a1.size());
        
        System.out.println(a1);
        
        Collections.sort(a1);
        
        System.out.println(a1);
        
    }
    
}

class Box<E extends WithClone<E>> {
    
    private E dato;
    
    public Box(E dato) {
        this.dato = dato;
    }
    
    public E getDato() {
        return this.dato.clone();
    }
    
}

class Map<K,V> {
    
    private K key;
    private V value;
    
    public Map(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public V getValue(K key) {
        return (this.key == key) ? this.value : null;
    }
    
}

class Dato implements WithClone<Dato>, Comparable<Dato> {
    private String dato;
    
    public Dato(String d) {
        setDato(d);
    }
    
    public String getDato() {
        return dato;
    }
    
    public void setDato(String d) {
        dato = d;
    }
    
    @Override
    public String toString() {
        return dato;
    }

    @Override
    public Dato clone() {
        return new Dato(dato);
    }

    @Override
    public int compareTo(Dato t) {
        return this.getDato().compareTo(t.getDato());
    }
    
}

class Clave implements WithClone<Clave> {
    private String dato;
    
    public Clave(String d) {
        setDato(d);
    }
    
    public String getDato() {
        return dato;
    }
    
    public void setDato(String d) {
        dato = d;
    }
    
    @Override
    public String toString() {
        return dato;
    }

    @Override
    public Clave clone() {
        return new Clave(dato + " - Clone");
    }
    
}

interface WithClone<T> {
    T clone();
}