package P18_StreamFiles;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;

public class E02_Files {

	public static void main(String[] args) {
		
		File path = new File("");
		String pwd = path.getAbsolutePath();
		System.out.println(pwd);
		
		System.out.println();
		
		File file = new File(".project");
		System.out.println(file.getAbsolutePath());
		System.out.println("File Exists: " + file.exists());
		System.out.println("Directory: " + file.isDirectory());
		
		System.out.println();
		
		File dir = new File(".");
		System.out.println(dir.getAbsolutePath());
		System.out.println("Directory: " + dir.isDirectory());
		
		System.out.println();
		
		Function<File, String> dataFile = new Function<File, String>() {

			@Override
			public String apply(File f) {
				StringBuilder data = new StringBuilder("");
				
				data.append("Path: " + f.getName() + "\n");
				data.append("Directory: " + f.isDirectory() + "\n");
				data.append("Execute Access: " + f.canExecute() + "\n");
				data.append("Read Access: " + f.canRead() + "\n");
				data.append("Write Access: " + f.canWrite() + "\n");
				data.append("Hidden: " + f.isHidden() + "\n");
				
				return data.toString();
			}
			
		};
		
		String DIR = String.join(File.separator, "src", "P18_StreamFiles");
		File cwd = new File(DIR);
		
		Arrays.asList(cwd.listFiles())
	      .stream()
	      .map(dataFile)
	      .forEach(System.out::println);
		
		File folder = new File("files");
		folder.mkdir();
		
		File testFile = new File(folder, "test.txt");
		try {
			testFile.createNewFile();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		testFile.setReadOnly();
		
		System.out.println(dataFile.apply(testFile));
		
		testFile.delete();
		
		System.out.println("Deleted: " + !testFile.exists());
	}

}
