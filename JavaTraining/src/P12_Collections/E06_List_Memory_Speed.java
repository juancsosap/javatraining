package P12_Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class E06_List_Memory_Speed {

	public static void main(String[] args) {

		final int SIZE = 100000;
		long starTime, stopTime, deltaTime;
								
		System.out.println("------ ARRAYLIST ------");

		System.out.printf("SIZE IN MEMORY:       %,d Bytes%n", (SIZE * Integer.SIZE)/8);
		
		starTime = System.currentTimeMillis();
		List<Integer> list1 = loadArrayList(SIZE);
		stopTime = System.currentTimeMillis();
		deltaTime = stopTime - starTime;
		System.out.printf("WRITE TIME REQUIRED:  %,d mSeconds%n", deltaTime);
		
		starTime = System.currentTimeMillis();
		readArrayList(list1);
		stopTime = System.currentTimeMillis();
		deltaTime = stopTime - starTime;
		System.out.printf("READ TIME REQUIRED:   %,d mSeconds%n", deltaTime);
		
		System.out.println("------ LINKEDLIST ------");

		System.out.printf("SIZE IN MEMORY:       %,d Bytes%n", (SIZE * (Integer.SIZE/8 + 10 * 2)));
		
		starTime = System.currentTimeMillis();
		List<Integer> list2 = loadLinkedList(SIZE);
		stopTime = System.currentTimeMillis();
		deltaTime = stopTime - starTime;
		System.out.printf("WRITE TIME REQUIRED:  %,d mSeconds%n", deltaTime);
		
		starTime = System.currentTimeMillis();
		readLinkedList(list2);
		stopTime = System.currentTimeMillis();
		deltaTime = stopTime - starTime;
		System.out.printf("READ TIME REQUIRED:   %,d mSeconds%n", deltaTime);
		
	}
	
	private static List<Integer> loadArrayList(int size) {
		List<Integer> list = new ArrayList<>(size); 
		for(int i=0; i<size; i++) {
			list.add(0, (new Random()).nextInt());
		}
		return list;
	}

	private static List<Integer> loadLinkedList(int size) {
		List<Integer> list = new LinkedList<>(); 
		for(int i=0; i<size; i++) {
			list.add(0, (new Random()).nextInt());
		}
		return list;
	}
	
	private static List<Integer> readArrayList(List<Integer> list) {
		List<Integer> result = new ArrayList<>(list.size()); 
		for(int i=0; i<list.size(); i++) {
			result.add(list.get(list.size()-i-1));
		}
		return result;
	}

	private static List<Integer> readLinkedList(List<Integer> list) {
		List<Integer> result = new LinkedList<>(); 
		for(int i=0; i<list.size(); i++) {
			result.add(list.get(list.size()-i-1));
		}
		return result;
	}

}