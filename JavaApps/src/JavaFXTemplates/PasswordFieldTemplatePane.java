package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;

public class PasswordFieldTemplatePane extends TemplatePane {
	
	private PasswordField passwordField, passwordFieldConfirmation;
	
	public PasswordFieldTemplatePane() {
		super("PasswordField Template");
		
		passwordField = new PasswordField();
		passwordField.setPromptText("Please Enter a valid Password (Press ENTER to Validate)");
		passwordField.setMinSize(100, 50);
		passwordField.setOnAction(ae -> validatePassword());
		
		passwordFieldConfirmation = new PasswordField();
		passwordFieldConfirmation.setPromptText("Please repeat the Password Entered to Confirm (Press ENTER to Validate)");
		passwordFieldConfirmation.setMinSize(100, 50);
		passwordFieldConfirmation.setOnAction(ae -> validateConfirmation());
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(passwordField, passwordFieldConfirmation);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private void validatePassword() {
		if(passwordField.getText().length() < 8) {
			passwordField.setText("");
		}
	}
	
	private void validateConfirmation() {
		if(!passwordField.getText().equals(passwordFieldConfirmation.getText())) {
			passwordFieldConfirmation.setText("");
		}
	}

}
