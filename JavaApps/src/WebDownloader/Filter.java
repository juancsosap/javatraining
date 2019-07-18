package WebDownloader;

import java.util.List;

public class Filter {
    
    private List<String> wl;
    
    public Filter(List<String> whiteList) {
        this.wl = whiteList;
    }
    
    public UrlType valid(String url) {
        String domain = Scanner.getDomain(url);
        String path = url.replace(domain, "");
        int dot = path.lastIndexOf(".");
        if(dot == -1) return UrlType.WEBPAGE;
        else {
            String ext = path.substring(dot + 1);
            return (wl.contains(ext)) ? UrlType.FILE : UrlType.INVALID;
        }
    }
    
    public static enum UrlType { 
        WEBPAGE(true), FILE(true), INVALID(false);
        
        private final boolean valid;
        
        private UrlType(boolean valid) {
            this.valid = valid;
        }
        
        public boolean isValid() {
            return this.valid;
        }
    
    }
    
}