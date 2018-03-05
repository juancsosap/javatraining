package BruteForceCracker;

import java.util.Date;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class BruteForceCalculator extends Service<String> {
	
	@Override
	protected Task<String> createTask() {
		return new Task<String>() {

			@Override
			protected String call() throws Exception {
				computePermutations(MainControler.password, 0);
			    
				return MainControler.count + "";
			}
			
			private String computePermutations(int[] password, int position) {
				String testString = "";
				String assemble = "";
				
				for(int i = 0; i < MainControler.chars.length(); i++) {
					
					password[position] = i;

				    if(position != MainControler.length - 1) {
				    	testString = computePermutations(password, position + 1);
				        if (testString != "") {
				        	return testString;
				        }
				    } else if(position == MainControler.length - 1) {
				        for(int j = 0; j < MainControler.length; j++) {
				        	assemble += MainControler.chars.charAt(password[j]);
				        }
				        
				        updateTitle(assemble);
				        
				        MainControler.count++;
				        updateValue(MainControler.count + "");
				        
				        if (assemble.equalsIgnoreCase(MainControler.testPassword)) {
				        	break; //replace this with: return assemble;
				        } else {
				        	assemble = "";
				        }
				        
				    }
				    if (isCancelled()) {
				    	break;
				    }
				}
				
				long tf = (new Date()).getTime();
			    String diff = (tf - MainControler.ti) + "";
			    
			    updateMessage(diff);
			    
				return "";
			}
			
		};

	}

}
