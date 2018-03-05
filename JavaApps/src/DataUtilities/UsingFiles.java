package DataUtilities;

import java.util.ArrayList;

public class UsingFiles {

	public static void main(String[] args) {
		
		String folder = "C:\\Users\\juanc\\Documents\\Trainings\\Netec\\DES1-APP-3C33 SCL\\";
		String file = "register.csv";
		
		FileUtil fileDriver = new FileUtil(folder + file);
		
		fileDriver.writeLine("Hola", true);
		ArrayList<String> archivo = fileDriver.readFile();
		
		for(int i=0; i<archivo.size(); i++) {
			System.out.println(archivo.get(i));
		}
		

	}

}
