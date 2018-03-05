package BruteForceCracker;

import java.util.Date;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BruteForce extends Application {

	private final String UPPERCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String LOWERCHARS = "abcdefghijklmnopqrstuvwxyz";
	private final String NUMBERS = "0123456789";
	private final String SYMBOLS = ".:,;-_<>?¿!¡#$%&/\\\"'()[]{}+*=~°|^ ";
	
	private Label lbLength, lbCharacters;
	private TextField tfLength, tfPassword, tfValues, tfCharacteres, tfTime;
	private CheckBox ckLowerLetters, ckUpperLetters, ckNumbers, ckSymbols;
	private Button btCalculate;
	
	private String testPassword = "";
	private String chars = "";
	private int length = 0;
	private long count = 0;
	private long ti;
	
	private Service<String> bgThread;
	
	private boolean enable = true;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		VBox pane = new VBox(10);
		pane.setPadding(new Insets(20, 20, 20, 20));
		
		// <---- Length Row
		HBox hbLength = new HBox(10);
		
		lbLength = new Label("Length");
		lbLength.setMinWidth(55);
		hbLength.getChildren().add(lbLength);
				
		tfLength = new TextField();
		tfLength.setOnKeyReleased(ke -> verifyOptions());
		tfLength.setMaxWidth(140);
		hbLength.getChildren().add(tfLength);
		
		lbCharacters = new Label("Characters");
		hbLength.getChildren().add(lbCharacters);
		
		pane.getChildren().add(hbLength);
		// ---->
		
		// <---- Options Row
		GridPane gpOption = new GridPane();
		gpOption.setHgap(50);
		gpOption.setVgap(10);
		
		ckLowerLetters = new CheckBox("Lower Letters");
		ckLowerLetters.setOnAction(ae -> verifyOptions());
		GridPane.setConstraints(ckLowerLetters, 0, 0);
		gpOption.getChildren().add(ckLowerLetters);
		
		ckUpperLetters = new CheckBox("Upper Letters");
		ckUpperLetters.setOnAction(ae -> verifyOptions());
		GridPane.setConstraints(ckUpperLetters, 0, 1);
		gpOption.getChildren().add(ckUpperLetters);
		
		ckNumbers = new CheckBox("Numbers");
		ckNumbers.setOnAction(ae -> verifyOptions());
		GridPane.setConstraints(ckNumbers, 1, 0);
		gpOption.getChildren().add(ckNumbers);
		
		ckSymbols = new CheckBox("Symbols");
		ckSymbols.setOnAction(ae -> verifyOptions());
		GridPane.setConstraints(ckSymbols, 1, 1);
		gpOption.getChildren().add(ckSymbols);
		
		pane.getChildren().add(gpOption);
		// ---->
		
		// <---- Button Row
		HBox hbCalculate = new HBox();
		
		Region space = new Region();
		HBox.setHgrow(space, Priority.ALWAYS);
		hbCalculate.getChildren().add(space);
		
		btCalculate = new Button("Calculate");
		btCalculate.setDisable(true);
		btCalculate.setOnAction(ae -> {
			if(enable) {
				calculatePassword();
			} else {
				bgThread.cancel();
			}
		});
		btCalculate.setMinSize(127, 30);
		hbCalculate.getChildren().add(btCalculate);
		
		pane.getChildren().add(hbCalculate);
		// ---->
		
		// <---- Password Row
		HBox hbPassword = new HBox(10);
		
		Label lbPassword = new Label("Password");
		lbPassword.setMinWidth(75);
		hbPassword.getChildren().add(lbPassword);

		tfPassword = new TextField();
		tfPassword.setDisable(true);
		tfPassword.setMaxWidth(120);
		hbPassword.getChildren().add(tfPassword);
		
		pane.getChildren().add(hbPassword);
		// ---->

		// <---- Characters Row
		HBox hbCharacters = new HBox(10);
		
		Label lbCharacteres = new Label("Chars");
		lbCharacteres.setMinWidth(75);
		hbCharacters.getChildren().add(lbCharacteres);

		tfCharacteres = new TextField();
		tfCharacteres.setDisable(true);
		tfCharacteres.setMaxWidth(120);
		hbCharacters.getChildren().add(tfCharacteres);
		
		pane.getChildren().add(hbCharacters);
		// ---->

		// <---- Values Row
		HBox hbValues = new HBox(10);
		
		Label lbCombinations = new Label("Combinations");
		lbCombinations.setMinWidth(75);
		hbValues.getChildren().add(lbCombinations);

		tfValues = new TextField();
		tfValues.setDisable(true);
		tfValues.setMaxWidth(120);
		hbValues.getChildren().add(tfValues);
		
		pane.getChildren().add(hbValues);
		// ---->
		
		// <---- Time Row
		HBox hbTime = new HBox(10);
		
		Label lbTime = new Label("Time");
		lbTime.setMinWidth(75);
		hbTime.getChildren().add(lbTime);

		tfTime = new TextField();
		tfTime.setDisable(true);
		tfTime.setMaxWidth(120);
		hbTime.getChildren().add(tfTime);
		
		Label lbSeconds = new Label("mSeconds");
		hbTime.getChildren().add(lbSeconds);
		
		pane.getChildren().add(hbTime);
		// ---->

		Scene scene = new Scene(pane, 300, 285);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("BruteForce");
		stage.show();
	}
	
	private void verifyOptions() {
		boolean isValid = ckLowerLetters.isSelected() || ckUpperLetters.isSelected() ||
		  		          ckNumbers.isSelected() || ckSymbols.isSelected();
		isValid &= tfLength.getText().matches("[1-9][0-9]*");
		isValid |= !enable;
		btCalculate.setDisable(!isValid);
	}
	
	private void calculatePassword() {
		
		count = 0;
		
		btCalculate.setText("Cancel");
		disableFields(true);
		
		enable = false;

		chars = "";
		chars += ckLowerLetters.isSelected() ? LOWERCHARS : "";
		chars += ckUpperLetters.isSelected() ? UPPERCHARS : "";
		chars += ckNumbers.isSelected() ? NUMBERS : "";
		chars += ckSymbols.isSelected() ? SYMBOLS : "";
		
		length = Integer.parseInt(tfLength.getText());
		int totalChars = chars.length();
		char lastChar = chars.charAt(chars.length()-1);
		
		tfCharacteres.setText(totalChars + "");
				
		// Generate Test Password with all chars equal to the last char to be tested
		for(int i=0; i<length; i++) {
			testPassword += lastChar;
		}
		
		ti = (new Date()).getTime();
		
		// Test Different Length Passwords
		int[] password = new int[length];
	    String[] finalPassword = new String[length];
	    for (int i = 0; i < length; i++) {
	    	password[i] = 0;
	    	finalPassword[i] = "";
	    }
		
		bgThread = new Service<String>() {

			@Override
			protected Task<String> createTask() {
				return new Task<String>() {

					@Override
					protected String call() throws Exception {
						computePermutations(password, 0);
					    
						return count + "";
					}
					
					private String computePermutations(int[] password, int position) {
						String testString = "";
						String assemble = "";
						
						for(int i = 0; i < chars.length(); i++) {
							
							password[position] = i;

						    if(position != length - 1) {
						    	testString = computePermutations(password, position + 1);
						        if (testString != "") {
						        	return testString;
						        }
						    } else if(position == length - 1) {
						        for(int j = 0; j < length; j++) {
						        	assemble += chars.charAt(password[j]);
						        }
						        
						        updateTitle(assemble);
						        
						        count++;
						        updateValue(count + "");
						        
						        if (assemble.equalsIgnoreCase(testPassword)) {
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
					    String diff = (tf - ti) + "";
					    
					    updateMessage(diff);
					    
						return "";
					}
					
				};
			}
			
		};
		
		bgThread.setOnSucceeded(wse -> {
			btCalculate.setText("Calculate");
			disableFields(false);
			
			enable = true;
			
			tfTime.textProperty().unbind();
			tfPassword.textProperty().unbind();
			tfValues.textProperty().unbind();
		});
		
		bgThread.setOnCancelled(wse -> {
			btCalculate.setText("Calculate");
			disableFields(false);
			
			enable = true;
			
			tfTime.textProperty().unbind();
			tfPassword.textProperty().unbind();
			tfValues.textProperty().unbind();
		});
		
		tfTime.textProperty().bind(bgThread.messageProperty());
		tfPassword.textProperty().bind(bgThread.titleProperty());
		tfValues.textProperty().bind(bgThread.valueProperty());
		
		bgThread.restart();
		
	}
	
	private void disableFields(boolean value) {
		ckLowerLetters.setDisable(value);
		ckUpperLetters.setDisable(value);
		ckNumbers.setDisable(value);
		ckSymbols.setDisable(value);
		tfLength.setDisable(value);
		lbLength.setDisable(value);
		lbCharacters.setDisable(value);
	}

}
