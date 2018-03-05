package Clock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StopWatcherWindow extends Application {
	
	private Label lbClock;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		lbClock = new Label();
		lbClock.setFont(new Font("Broadway", 40));
		
		StopWatcher timer = new StopWatcher(value -> lbClock.setText(value), new Time(), false, new Time(1));
		
		Button btPlay = new Button("Play");
		btPlay.setOnAction(ae -> {
			if(btPlay.getText().equals("Play")) {
				timer.start();
				btPlay.setText("Pause");
			} else {
				timer.pause();
				btPlay.setText("Play");
			}
		});
		btPlay.setFont(new Font("Broadway", 25));
		btPlay.setMinSize(150, 40);
		
		Button btStop = new Button("Stop");
		btStop.setOnAction(ae -> {
			timer.stop();
			if(btPlay.getText().equals("Pause"))
				btPlay.setText("Play");
		});
		btStop.setFont(new Font("Broadway", 25));
		btStop.setMinSize(150, 40);
		
		HBox buttonPane = new HBox(20);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(btPlay, btStop);
		
		VBox mainPane = new VBox(20);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().addAll(lbClock, buttonPane);
		
		Scene scene = new Scene(mainPane, 500, 150);
		
		stage.setTitle("Personal Clock");
		stage.setScene(scene);
		stage.show();
	}

}
