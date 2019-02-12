package WebDownloader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Controller {
    
    public static void init(String startUrl, String baseFolder, String ... whiteList) {
        
        String url = startUrl;
        Path folderPath = Paths.get(baseFolder, "page.tmp");
        String temp = folderPath.toString();
        
        Lister lister = new Lister(url);
        Filter filter = new Filter(Arrays.asList(whiteList));
        Saver saver = new Saver(baseFolder);
        
        Downloader.download(url, temp, true);
        lister.add(Scanner.scan(temp, startUrl));
        while((url = lister.getNext()) != null) {
            Filter.UrlType type = filter.valid(url);
            if(type.equals(Filter.UrlType.WEBPAGE)) {
                Downloader.download(url, temp, true);
                lister.add(Scanner.scan(temp, url));
            } else if(type.equals(Filter.UrlType.FILE)) {
                saver.save(url);
            }
        } 
        
    }
    
}