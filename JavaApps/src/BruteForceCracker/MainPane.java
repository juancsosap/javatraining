package BruteForceCracker;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MainPane extends VBox {

	public Label lbLength, lbCharacters;
	public TextField tfLength, tfPassword, tfValues, tfCharacteres, tfTime;
	public CheckBox ckLowerLetters, ckUpperLetters, ckNumbers, ckSymbols;
	public Button btCalculate;
	
	public MainPane(double spacing) {
		super(spacing);
		
		setPadding(new Insets(20, 20, 20, 20));
		
		// <---- Length Row
		HBox hbLength = new HBox(10);
		
		lbLength = new Label("Length");
		lbLength.setMinWidth(55);
		hbLength.getChildren().add(lbLength);
				
		tfLength = new TextField();
		tfLength.setMaxWidth(140);
		hbLength.getChildren().add(tfLength);
		
		lbCharacters = new Label("Characters");
		hbLength.getChildren().add(lbCharacters);
		
		getChildren().add(hbLength);
		// ---->
		
		// <---- Options Row
		GridPane gpOption = new GridPane();
		gpOption.setHgap(50);
		gpOption.setVgap(10);
		
		ckLowerLetters = new CheckBox("Lower Letters");
		GridPane.setConstraints(ckLowerLetters, 0, 0);
		gpOption.getChildren().add(ckLowerLetters);
		
		ckUpperLetters = new CheckBox("Upper Letters");
		GridPane.setConstraints(ckUpperLetters, 0, 1);
		gpOption.getChildren().add(ckUpperLetters);
		
		ckNumbers = new CheckBox("Numbers");
		GridPane.setConstraints(ckNumbers, 1, 0);
		gpOption.getChildren().add(ckNumbers);
		
		ckSymbols = new CheckBox("Symbols");
		GridPane.setConstraints(ckSymbols, 1, 1);
		gpOption.getChildren().add(ckSymbols);
		
		getChildren().add(gpOption);
		// ---->
		
		// <---- Button Row
		HBox hbCalculate = new HBox();
		
		Region space = new Region();
		HBox.setHgrow(space, Priority.ALWAYS);
		hbCalculate.getChildren().add(space);
		
		btCalculate = new Button("Calculate");
		btCalculate.setDisable(true);
		btCalculate.setMinSize(127, 30);
		hbCalculate.getChildren().add(btCalculate);
		
		getChildren().add(hbCalculate);
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
		
		getChildren().add(hbPassword);
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
		
		getChildren().add(hbCharacters);
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
		
		getChildren().add(hbValues);
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
		
		getChildren().add(hbTime);
		// ---->
	}
	
}
