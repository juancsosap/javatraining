package JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControlerJavaFX implements Initializable {
	
	public Button doneButton;
	public Label nick, msg;
	
	public void doneButtonHandler() {
		msg.setText("How are you?");
	}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		nick.setText("user.nuage");
	}

}
