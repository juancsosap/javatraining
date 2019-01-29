package WebDownloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scanner {

    private static String base;
    private static String domain;
    
    public static Set<String> scan(String file, String url) {
        
        base = url.substring(0, url.lastIndexOf("/")+1);
        domain = getDomain(url);
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            
            return lines.stream().flatMap(hrefGetter)
                                 .map(urlAbsoluter)
                                 .filter(inDomain)
                                 .collect(Collectors.toSet());
            
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        
        return null;
        
    }
    
    private static Function<String, Stream<String>> hrefGetter = (x) -> {
        String[] arrayOutput = x.split("href=");
        int size  = arrayOutput.length;
        List<String> links = new ArrayList<>();
        for(int i = 1; i < size; i++) {
            String output = arrayOutput[i];
            char delimiter = output.charAt(0);
            int end = output.indexOf(delimiter, 1);
            links.add(output.substring(1, end));
        }
        return links.stream();
    };
    
    private static Function<String, String> urlAbsoluter = (url) -> {
    	if(url.length() == 0) return base;
    	if(url.matches("^(.{3,}:)?//.+$")) return url;
        if(url.charAt(0) == '/') return domain + url;
        return base + url;
    };
    
    private static Predicate<String> inDomain = (url) -> {
        return getDomain(url).equals(domain);
    };
    
    private static String getDomain(String url) {
    	int end = url.indexOf("/", 10);
        return (end == -1) ? url : url.substring(0, end);
    }
    
}
