package JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FifthWindow extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("User SingIn");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(10);
		
		Label nameLabel = new Label("Username:");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		TextField nameInput = new TextField("Juan");
		nameInput.setPromptText("username");
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Label ageLabel = new Label("Age:");
		GridPane.setConstraints(ageLabel, 0, 2);
		
		TextField ageInput = new TextField();
		ageInput.setPromptText("current age");
		GridPane.setConstraints(ageInput, 1, 2);
		
		Label countryLabel = new Label("Country:");
		GridPane.setConstraints(countryLabel, 0, 3);
		
		ComboBox<String> countryComboBox = new ComboBox<>();
		GridPane.setConstraints(countryComboBox, 1, 3);
		countryComboBox.setEditable(true);
		countryComboBox.getItems().addAll("Chile", "Peru", 
				                           "Colombia", "Argentina");
		countryComboBox.setValue("Chile");
		
		Label capitalLabel = new Label("Capital:");
		GridPane.setConstraints(capitalLabel, 0, 4);
		
		TextField capitalInput = new TextField("Santiago");
		capitalInput.setEditable(false);
		GridPane.setConstraints(capitalInput, 1, 4);
		
		countryComboBox.setOnAction(ae -> {
			String[] countries = {"Chile", "Peru", "Colombia", "Argentina"};
			String[] capitals = {"Santiago", "Lima", "Bogota", "Buenos Aires"};
			boolean presetvalue = false;
			for(int i=0; i < countries.length; i++) {
				if(countries[i].equals(countryComboBox.getValue())) {
					capitalInput.setText(capitals[i]);
					presetvalue = true;
					break;
				}
			}
			capitalInput.setEditable(!presetvalue);
			if(!presetvalue)
				capitalInput.setText("");
		});
		
		Label preferenceLabel = new Label("Preference:");
		GridPane.setConstraints(preferenceLabel, 0, 5);
		
		CheckBox[] preferenceCheckBoxes = new CheckBox[4];
		
		preferenceCheckBoxes[0] = new CheckBox("Technology");
		GridPane.setConstraints(preferenceCheckBoxes[0], 1, 5);
		preferenceCheckBoxes[1] = new CheckBox("Health");
		GridPane.setConstraints(preferenceCheckBoxes[1], 1, 6);
		preferenceCheckBoxes[2] = new CheckBox("Fitness");
		GridPane.setConstraints(preferenceCheckBoxes[2], 1, 7);
		preferenceCheckBoxes[3] = new CheckBox("Science");
		GridPane.setConstraints(preferenceCheckBoxes[3], 1, 8);
		
		Label publicationsLabel = new Label("Publications:");
		GridPane.setConstraints(publicationsLabel, 0, 9);
		
		ListView<String> publicationsListView = new ListView<>();
		publicationsListView.getItems().addAll("National Geographics",
				                               "Popular Mechanical",
				                               "Cosmopolitan");
		
		
		Button signInButton = new Button("Sign In");
		GridPane.setConstraints(signInButton, 1, 10);
		signInButton.setMinWidth(100);
		signInButton.setOnAction(ae -> {
			boolean valid = true; 
			valid &= validAge(ageInput);
			valid &= validPreferences(preferenceCheckBoxes);

			if(!valid) {
				AlertBox.display("Invalid data", "Information Invalid");
			}
		});

		grid.getChildren().addAll(nameLabel, nameInput, 
				                  passLabel, passInput, 
				                  ageLabel,  ageInput,
				                  countryLabel, countryComboBox, 
				                  capitalLabel,  capitalInput,
				                  preferenceLabel,
				                  preferenceCheckBoxes[0], 
				                  preferenceCheckBoxes[1],
				                  preferenceCheckBoxes[2], 
				                  preferenceCheckBoxes[3],
				                  signInButton);
		
		Scene scene = new Scene(grid, 240 ,300);
		mainStage.setScene(scene);
		mainStage.show();
	}
	
	private boolean validAge(TextField tf) {
		try {
			Integer.parseInt(tf.getText());
			return true;
		} catch(NumberFormatException ex) {
			return false;
		}
	}
	
	private boolean validPreferences(CheckBox[] chbxs) {
		boolean checked = false;
		for(CheckBox cb : chbxs) {
			checked |= cb.isSelected();
		}
		return checked;
	}

}