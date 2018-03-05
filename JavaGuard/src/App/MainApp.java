package App;

import Controller.MainPaneController;
import View.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		MainPane pane = new MainPane();
		
		Scene scene = new Scene(pane, 300, 400);
		scene.getStylesheets().add("style.css");
		
		stage.setOnShowing(we -> MainPaneController.cargarInicial(pane));
		
		stage.setScene(scene);
		stage.setTitle("Registro de Acceso");
		stage.setResizable(false);
		stage.show();
	}

}
