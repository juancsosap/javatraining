package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJavaFX extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		mainStage.setTitle("Hello World");
		mainStage.setScene(new Scene(root, 300, 300));
		mainStage.show();
	}
	
	

}
