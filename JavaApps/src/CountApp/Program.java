package CountApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		try {
			List<Map<String, Integer>> list = new ArrayList<>();
			
			String url1 = "https://www.ietf.org/rfc/rfc1918.txt";
			String text1 = Downloader.download(url1);
			Map<String, Integer> output1 = WordCounter.count(text1);
			FileSaver.save(output1, "test1.txt");
			list.add(output1);
			
			String url2 = "https://www.ietf.org/rfc/rfc1919.txt";
			String text2 = Downloader.download(url2);
			Map<String, Integer> output2 = WordCounter.count(text2);
			FileSaver.save(output2, "test2.txt");
			list.add(output2);
			
			Map<String, Integer> output = Analytics.analyze(20, list);
			for(String key : output.keySet()) {
				System.out.println(key + " : " + output.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}

	}

}
