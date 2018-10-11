package netec.ocp.advanced;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("My First App");
		//stage.setIconified(true);
		//stage.setResizable(false);
		
		Button b1 = new Button();
		b1.setText("Mi primer boton en JavaFx");
		
		Button b2 = new Button();
		b2.setText("Mi 2do boton en JavaFx");
		
		HBox root = new HBox();
		root.getChildren().add(b1);
		root.getChildren().add(b2);
		
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		
		stage.show();
		
	}

}
