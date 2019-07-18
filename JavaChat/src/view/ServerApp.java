package view;

import java.net.Socket;

import controler.Informable;
import controler.Server;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ServerApp extends Application implements Informable {

	VBox chatPane = new VBox(10);
	Server server = new Server(this);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		chatPane.getStyleClass().add("chat-pane");
		
		ScrollPane scrollPane = new ScrollPane();
		BorderPane.setMargin(scrollPane, new Insets(0, 0, 10, 0));
		scrollPane.setPadding(new Insets(10, 10, 10, 10));
		scrollPane.setContent(chatPane);
		scrollPane.vvalueProperty().bind(chatPane.heightProperty());
		
		Button btStart = new Button("Start Server");
		btStart.setOnAction(ae -> server.startServer());
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setCenter(scrollPane);
		pane.setBottom(btStart);
		
		Scene scene = new Scene(pane, 350, 500);
		scene.getStylesheets().add("style.css");
		
		stage.setScene(scene);
		stage.getIcons().add(new Image("chat.png"));
		stage.setTitle("JChat Server");
		stage.show();
	}
	
	@Override
	public void stop() throws Exception {
		server.disable();
	}

	@Override
	public void inform(Object obj) {
		Socket skt = (Socket) obj;
		String msg = skt.getInetAddress() + ":" + skt.getPort();
		chatPane.getChildren().add(new Label(msg));
	}

}
