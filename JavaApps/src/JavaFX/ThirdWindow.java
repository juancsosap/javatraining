package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ThirdWindow extends Application {
	
	Stage window;
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		window = mainStage;
		window.setTitle("Title of my Window");
		
		window.setOnCloseRequest(ae -> {
			ae.consume();
			if(ConfirmWindow.display("Confirmation Message", 
				       "Really you want to close it!!!")) {
				window.close();
			}
		});
		
		button = new Button("Click me!!!");
		button.setOnAction(ae -> AlertWindow.display("Title", "Now Close me!!!"));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 300);
		
		window.setScene(scene);
		
		window.show();
	}

}
