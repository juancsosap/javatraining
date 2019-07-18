package WebDownloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {
    
    public static void init(String startUrl, String baseFolder, String ... whiteList) {
        
        String url = startUrl;
        Path temp = getTempFile(baseFolder);
        
        Lister lister = new Lister(url);
        Filter filter = new Filter(Arrays.asList(whiteList));
        Saver saver = new Saver(baseFolder);
        
        Downloader.download(url, temp.toString(), true);
        lister.add(Scanner.scan(temp.toString(), startUrl));
        try {
            Files.delete(temp);
        } catch (IOException ex) {
            System.err.println("Execution Error Deleting File");
        }
        
        ExecutorService pool = Executors.newFixedThreadPool(10);
        
        while((url = lister.getNext()) != null) {
            pool.submit(new Proccessor(lister, filter, saver, baseFolder, url));
        } 
        
        pool.shutdown();
        
    }
    
    private static class Proccessor implements Runnable {

        private Lister lister;
        private Filter filter;
        private Saver saver;
        private String baseFolder, url;
        
        public Proccessor(Lister lister, Filter filter, Saver saver, String baseFolder, String url) {
            this.lister = lister;
            this.filter = filter;
            this.saver = saver;
            this.baseFolder = baseFolder;
            this.url = url;
        }
        
        @Override
        public void run() {
            Filter.UrlType type = filter.valid(url);
            if(type.equals(Filter.UrlType.WEBPAGE)) {
                Path temp = getTempFile(baseFolder);
                Downloader.download(url, temp.toString(), true);
                lister.add(Scanner.scan(temp.toString(), url));
                try {
                    Files.delete(temp);
                } catch (IOException ex) {
                    System.err.println("Execution Error Deleting File");
                }
            } else if(type.equals(Filter.UrlType.FILE)) {
                saver.save(url);
            }
        }
    
    }
    
    public static Path getTempFile(String baseFolder) {
        int number = ThreadLocalRandom.current().nextInt(0, 1_000_000_000);
        return Paths.get(baseFolder, number + ".tmp");
    }
    
}