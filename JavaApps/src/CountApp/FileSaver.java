package CountApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileSaver {

	public static void save(Map<String, Integer> input, String path) throws IOException {
		Path file = Paths.get(path);
		if(!Files.exists(file)) Files.createFile(file);
		List<String> lines = new ArrayList<>();
		for(String key : input.keySet()) {
			lines.add(key + " : " + input.get(key));
		}
		Files.write(file, lines, StandardOpenOption.WRITE);
	}
	
}
