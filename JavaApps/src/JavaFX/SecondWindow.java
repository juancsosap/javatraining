package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondWindow extends Application {
	
	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		window = mainStage;
		window.setTitle("Title of my Window");
		
		Label label1 = new Label("Welcome to the first scene!");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(ae -> mainStage.setScene(scene2));
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		
		scene1 = new Scene(layout1, 200, 200);
		
		Button button2 = new Button("Go to scene 1");
		button2.setOnAction(ae -> mainStage.setScene(scene1));
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2, 600, 300);
		
		window.setScene(scene1);
		
		window.show();
	}

}
