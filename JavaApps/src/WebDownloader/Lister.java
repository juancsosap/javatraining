package WebDownloader;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Lister {
    
    private final ConcurrentMap<String, Boolean> urls;
    
    public Lister(String url) {
        urls = new ConcurrentHashMap<>();
        urls.put(url, true);
    }
    
    public void add(Set<String> urls) {
        ConcurrentMap<String, Boolean> newUrls = urls.stream().filter((s) -> !this.urls.keySet().contains(s))
                                                              .distinct()
                                                              .collect(Collectors.toConcurrentMap((s) -> s, (s) -> false));
        this.urls.putAll(newUrls);
    }
    
    public String getNext() {
        String url = this.urls.keySet().stream().filter((s) -> !this.urls.get(s)).findFirst().orElse(null);
        if(url != null) this.urls.put(url, true);
        return url;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.urls.forEach((k, v) -> sb.append(k).append(" : ").append(v).append("\n"));
        return sb.toString();
    }
    
}