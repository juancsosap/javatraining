package P18_StreamFiles;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;

public class E07_NIOFileSystem {

	public static void main(String[] args) {

		FileSystem fs = FileSystems.getDefault();
		fs.supportedFileAttributeViews().forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Separator: " + fs.getSeparator());
		System.out.println("Open: " + fs.isOpen());
		System.out.println("ReadOnly: " + fs.isReadOnly());
		
		System.out.println();
		
		fs.getRootDirectories().forEach(System.out::println);
		
		System.out.println();
		
		fs.getFileStores()
		  .forEach(f -> {
			try {
				StringBuilder data = new StringBuilder("");
				
				data.append("Name: " + f.name() + "\n");
				data.append("Type: " + f.type() + "\n");
				data.append("Total Space: " + f.getTotalSpace() + "\n");
				data.append("Usable Space: " + f.getUsableSpace() + "\n");
				data.append("Unallocated Space: " + f.getUnallocatedSpace() + "\n");
				data.append("ReadOnly: " + f.isReadOnly() + "\n");
				data.append("Support Basic Attributes: " + f.supportsFileAttributeView(BasicFileAttributeView.class) + "\n");
				
				System.out.println(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		Path file = fs.getPath("files", "test.txt");
		
		System.out.println(file);
		System.out.println(file.toAbsolutePath());
		
	}

}
