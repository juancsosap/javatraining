package ocp;

import java.util.function.BiConsumer;

public class PrimosAsimetricos {

	public static void main(String[] args) {
		buscarPrimos(100);
	}
	
	public static final BiConsumer<Integer, Boolean> cb = (num, result) -> {
		if(result) System.out.println(num + " es primo.");
	};
	
	public static void buscarPrimos(int max) {
		for(int i = 0; i < max; i++) {
			esPrimo(i+1, cb);
		}
	}
	
	public static void esPrimo(int num, BiConsumer<Integer, Boolean> cb) {
		if(num < 2) cb.accept(num, false);
		else {
			for(int i = 2; i < num; i++) {
				if(num % i == 0) {
					cb.accept(num, false);
					return;
				}
			}
			cb.accept(num, true);
		}
	}

}
