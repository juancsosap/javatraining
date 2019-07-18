package netec.ocp.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTesting {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Juans", "Luis", "Pepes", "Marias", "Antonios", "Luisa", "Anas", "Carlos", "Abels", "Cains", "Set", "Cams", "Adams", "Evas");
		/*
		names.forEach(d -> System.out.println(d));
		
		System.out.println();
		
		names.stream().forEach(System.out::println);
		
		System.out.println();
		*/
		names.stream().filter(d -> d.length() <= 4)
		              .filter(d -> !d.startsWith("L"))
		              .skip(2)
		              .limit(5)
		              .peek(d -> System.out.print(d + " : "))
		              .map(d -> d.toUpperCase())
		              .forEach(System.out::println);
		
		System.out.println();
		
		boolean verify = names.stream().map(d -> d.toLowerCase()).noneMatch(d -> d.indexOf("a") != -1);
		System.out.println(verify);
		
		System.out.println();
		
		
		Optional<String> dato = names.stream().filter(d -> d.length() < 5).findFirst(); 
		if(dato.isPresent())
			System.out.println(dato.get());
	
		String dato1 = names.stream().filter(d -> d.length() < 6).findFirst().orElse("NO DATO"); 
		System.out.println(dato1);
	
		System.out.println();
		
		String unidos = names.stream().collect(Collectors.joining(","));
		System.out.println(unidos);
		
	}

}
