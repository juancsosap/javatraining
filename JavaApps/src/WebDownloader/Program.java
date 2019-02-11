package WebDownloader;

import java.util.Arrays;

public class Program {
    
    public static void main(String[] args) {
        
        String url = "http://www.radioarmonia.cl/inicio/podcast/";
        String target = "weboutput/page.html";
        Lister lister = new Lister(url);
        Filter filter = new Filter(Arrays.asList(new String[] {""}));
        
        Downloader.download(url, target, true);
        lister.add(Scanner.scan(target, url));
        while((url = lister.getNext()) != null) {
            if(filter.valid(url).isValid()) {
                Downloader.download(url, target, true);
                if(filter.valid(url) == Filter.UrlType.WEBPAGE)
                    lister.add(Scanner.scan(target, url));
                System.out.println("NEW DATA");
                System.out.println(lister);
                System.out.println("\n\n\n");
            }
        }
        
    }
    
}
