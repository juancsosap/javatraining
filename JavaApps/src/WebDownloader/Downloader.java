package WebDownloader;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class Downloader {
 
    public static void download(String url, String target, boolean binary) {

        try {
            System.err.println("Downloading file from " + url);
            URL website = new URL(url);
            
            try(InputStream in = website.openStream()) {
                
                if(binary) {
                    try(OutputStream out = new FileOutputStream(target)) {
                        int bytes;
                        byte[] buffer = new byte[1024];
                        while((bytes = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytes);		
                        }
                    }
                } else {
                    try(Reader inRead = new InputStreamReader(in);
                        BufferedReader inBuffer = new BufferedReader(inRead);
                        Writer outWrite = new FileWriter(target)){
                        String line;
                        while((line = inBuffer.readLine()) != null) {
                            outWrite.write(line + "\n");
                        }
                    }
                }
                
            }
            
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
    public static void download(String url, String target) { download(url, target, false); }
    
}
