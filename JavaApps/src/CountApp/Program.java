package CountApp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		
		App myApp = new App();
        
        List<String> files = new ArrayList<>();
        for(int i = 1; i < 100; i++) {
            files.add("rfc" + i + ".txt");
        }
        
        
        LocalDateTime tini = LocalDateTime.now();
        myApp.init("https://tools.ietf.org/rfc/", files, "output/", 10, true);
        LocalDateTime tend = LocalDateTime.now();
        Duration tdif = Duration.between(tini, tend);
        
        LocalDateTime sini = LocalDateTime.now();
        myApp.init("https://tools.ietf.org/rfc/", files, "output/", 10, false);
        LocalDateTime send = LocalDateTime.now();
        Duration sdif = Duration.between(sini, send);
        
        System.out.println("Time Excecution with Threads : " + tdif.getSeconds() + " seconds");
        System.out.println("Time Excecution without Threads : " + sdif.getSeconds() + " seconds");

	}

}
