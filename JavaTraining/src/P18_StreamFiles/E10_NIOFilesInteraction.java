package P18_StreamFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class E10_NIOFilesInteraction {

	public static void main(String[] args) {

		Path DIR = Paths.get("files");
		
		Path file = DIR.resolve("myFile.txt");
		Path copyFile = DIR.resolve("myFile-copy.txt");
		
		try {
			List<String> lines = Files.readAllLines(file);
			lines.forEach(System.out::println);
			Files.write(copyFile, lines, StandardOpenOption.WRITE);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println();
		
		Path bkpFile = DIR.resolve("myFile-bkp.txt");
		
		try {
			byte[] bytes = Files.readAllBytes(file);
			List<Byte> listBytes = new ArrayList<>();
			for(Byte b : bytes) {
				listBytes.add(b);
			}
			listBytes.stream().map(d -> (char)(int) d).forEach(System.out::print);
			Files.write(bkpFile, bytes);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
