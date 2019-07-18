package JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FirstWindow extends Application implements EventHandler<ActionEvent> {
	
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("Title of my Window");
		
		button = new Button();
		button.setText("Click me");
		button.setOnAction(this);
		
		Button buttonClose = new Button();
		buttonClose.setText("Close It");
		buttonClose.setOnAction(ae -> System.out.println("Ups.... You can't close me!!!"));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		//layout.getChildren().add(buttonClose);
		
		Scene scene = new Scene(layout, 300, 300);
		mainStage.setScene(scene);
		mainStage.show();
	}

	@Override
	public void handle(ActionEvent ae) {
		if(ae.getSource() == button) {
			System.out.println("Click me again!!!!!!!");
		}
	}

}
