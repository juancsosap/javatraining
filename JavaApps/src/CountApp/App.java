package CountApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

	private String folderURL;
    private String outputFolder;
    private List<Map<String, Integer>> list;
    
    public void init(String folderURL, List<String> files, String outputFolder, int top, boolean threading) {
        
    	try {
    		this.folderURL = folderURL;
	        this.outputFolder = outputFolder;
	        list = new ArrayList<>();
	        
	        if(threading) {
		        List<Runner> runners = new ArrayList<>();
		        
		        for(String file : files) {
	        		while(count > 200){
	                    Thread.sleep(10);
	                }
	                Runner runner = new Runner(file);
	                runner.start();
	                runners.add(runner);
		        }
		        
		        for(Runner runner : runners) {
		            runner.join();
		        }
	        } else {
	        	for(String file : files) {
	        		Runner runner = new Runner(file);
	                runner.run();
		        }
	        }
	            
	        Map<String, Integer> output = Analytics.analyze(top, list);
	        Printer.print(output);
	        
    	} catch (InterruptedException ex) {
            System.out.println("Thread Interrupted");
        }
    }
    
    public static int count = 0;
    
    private class Runner extends Thread {
    
        private String file;
        
        public Runner(String file) {
            this.file = file;
            count++;
        }
    
        @Override
        public void run() {
            try {
                String url = folderURL + file;
                String text = Downloader.download(url);
                if(text == null) return; 
                Map<String, Integer> output = WordCounter.count(text, file);
                FileSaver.save(output, outputFolder + file);
                list.add(output);
            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            } finally {
                count--;
            }
        }

    }
}
