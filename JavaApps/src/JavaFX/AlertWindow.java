package JavaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
	
	public static void display(String title, String msg) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		window.setMinHeight(130);
		
		Label label = new Label();
		label.setText(msg);
		
		Button closeButton = new Button("Close it!!!");
		closeButton.setOnAction(ae -> {
			if(ConfirmWindow.display("Confirmation Message", 
					       "Really you want to close it!!!")) {
				window.close();
			}
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		window.showAndWait();
	}

}
