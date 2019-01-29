package WebDownloader;

public class Program {
    
    public static void main(String[] args) {
        
        String url = "https://www.cascadadelasanimas.cl";
        String target = "output/page.html";
        Downloader.download(url, target);
        
        Scanner.scan(target, url).forEach(System.out::println);
        
    }
    
}
