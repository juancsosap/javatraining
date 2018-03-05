package BruteForceCracker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		MainPane pane = new MainPane(10);
		
		Scene scene = new Scene(pane, 300, 285);
		
		stage.setOnShowing(we -> MainControler.initialLoad(pane));
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("BruteForce");
		stage.show();
	}

}
