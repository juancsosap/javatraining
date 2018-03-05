package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FourthWindow extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("Layout Window");
		
		Button mf = new Button("File");
		Button me = new Button("Edit");
		Button mv = new Button("View");
		
		HBox topmenu = new HBox();
		topmenu.getChildren().addAll(mf, me, mv);
		
		Button ms = new Button("Save");
		Button ml = new Button("Load");
		Button mp = new Button("Print");
		
		VBox leftmenu = new VBox();
		leftmenu.getChildren().addAll(ms, ml, mp);
		
		BorderPane layout = new BorderPane();
		layout.setTop(topmenu);
		layout.setLeft(leftmenu);
		
		Scene scene = new Scene(layout, 300, 300);
		mainStage.setScene(scene);
		mainStage.show();
	}

}
