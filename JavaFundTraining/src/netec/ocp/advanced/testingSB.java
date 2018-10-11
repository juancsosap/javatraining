package netec.ocp.advanced;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class testingSB {

	public static void main(String[] args) {
		
		try {
			
			List l = new ArrayList();
				
			while(true) {
				l.add("Hola");
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
