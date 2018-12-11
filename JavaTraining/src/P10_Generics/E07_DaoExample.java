package P10_Generics;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class E07_DaoExample {

	public static void main(String[] args) {
		

	}
	
	private interface Indexable {
		public int getId();
	}
	
	private interface Dao<T extends Indexable> {
		public T create(T dato);
		public T retrive(int id);
		public T update(T dato);
		public T delete(T dato);
	}
	
	private class Animal implements Indexable {
		public String nombre;
		public int edad;
		public String especie;
		public int id;
		
		public Animal(int id, String nombre, int edad, String especie) {
			this.id = id;
			this.nombre = nombre;
			this.edad = edad;
			this.especie = especie;
		}

		@Override
		public int getId() {
			return this.id;
		}
	}

	private class Alimento {
		public String nombre;
		
		public Alimento(String nombre) {
			this.nombre = nombre;
		}
	}

	private class MemoryDB {
		public ArrayList<Animal> animales = new ArrayList<>();
		
		public MemoryDB() {
			animales.add(new Animal(1, "Pumba", 5, "Leon"));
			animales.add(new Animal(2, "Balum", 10, "Oso"));
		}
	}

	/*
	private class AlimentoDao implements Dao<Alimento> {
		
	}
	*/
	
	private class AnimalDao implements Dao<Animal> {

		@Override
		public Animal create(Animal dato) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Animal retrive(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Animal update(Animal dato) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Animal delete(Animal dato) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}


