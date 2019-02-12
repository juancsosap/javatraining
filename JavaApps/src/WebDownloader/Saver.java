package WebDownloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Saver {
    
    private final Path baseFolder;
    
    public Saver(String baseFolder) {
        this.baseFolder = Paths.get(baseFolder);
    }
    
    public void save(String url) {
        int index = url.lastIndexOf("/");
        String file = url.substring(index+1);
        String folder = url.replace(Scanner.getDomain(url), "")
                           .replace(file, "")
                           .substring(1);
        
        Path folderPath = baseFolder.resolve(folder);
        Path filePath = folderPath.resolve(file);
        
        try {
             if(Files.notExists(folderPath)) {
                Files.createDirectories(folderPath);
             }
             if(Files.notExists(filePath)) {
                Downloader.download(url, filePath.toString(), true);
             }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
}