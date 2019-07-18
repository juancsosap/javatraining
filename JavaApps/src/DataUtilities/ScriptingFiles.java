package DataUtilities;

import java.util.ArrayList;

public class ScriptingFiles {

	public static void main(String[] args) {
		
		String folder = "src\\data";
		String file = "data.txt";
		
		FileUtil fileDriver = new FileUtil(folder + file);
		ArrayList<String> archivo = fileDriver.readFile();
		
		for(int i=0; i<archivo.size(); i++) {
			String[] data = archivo.get(i).split(",");
			int result = 0;
			for(int j=0; j<data.length; j++) {
				result += Integer.valueOf(data[j]);
			}
			if(args.length > 0) {
				result *= Integer.valueOf(args[0]);
			}
			System.out.println(archivo.get(i) + " = " + result);
		}

	}

}
