package netec.ocp.advanced;

import java.util.ArrayList;
import java.util.List;

public class testingSB {

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
