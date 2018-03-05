package JavaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmWindow {
	
	static boolean answer;
	
	public static boolean display(String title, String msg) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		window.setMinHeight(160);
		
		Label label = new Label();
		label.setText(msg);
		
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(ae -> {
			answer = true;
			window.close();
		});
		
		Button noButton = new Button("No");
		noButton.setOnAction(ae -> {
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		window.showAndWait();
		
		return answer;
	}

}
