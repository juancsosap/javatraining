package WebDownloader;

public class Program {
    
    public static void main(String[] args) {
       
        String url = "http://www.radioarmonia.cl/inicio/podcast/";
        String folder = "";
        Controller.init(url, folder, new String[] {"mp3", "pdf", "avi"});
        
    }
    
}