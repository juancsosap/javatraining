package P18_StreamFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E14_files {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("files/boq.txt");
		Path resultFile = Paths.get("files/boq2.txt");
		
		List<String> output = Files.lines(path).flatMap(l -> {
			List<String> line = Arrays.asList(l.split("\t"));
			int length = line.size();
			List<String> result = new ArrayList<>();
			int quantity = Integer.parseInt(line.get(length - 1));
			for(int i=0; i<quantity; i++) {
				result.add(line.stream().collect(Collectors.joining("\t")));
			}
			return result.stream();
		}).collect(Collectors.toList());
		
		Files.write(resultFile, output, StandardOpenOption.WRITE);
		
	}

}
