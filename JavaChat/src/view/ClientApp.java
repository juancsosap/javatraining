package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controler.Client;
import controler.Informable;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientApp extends Application implements Informable {

	private TextField chatInput = new TextField();
	private TextField userInput = new TextField();
	VBox chatPane = new VBox(10);
	
	private String username = "";
	private Client client = new Client(this);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		chatPane.getStyleClass().add("chat-pane");
		
		Button btConnect = new Button("Connect");
		btConnect.setMinSize(120, 30);
		btConnect.setDisable(true);
		btConnect.setOnAction(ae -> {
			if(btConnect.getText().equals("Connect")) {
				client.connect();
				chatInput.setDisable(false);
				userInput.setDisable(true);
				btConnect.setText("Disconnect");
			} else {
				client.disconnect();
				chatInput.setDisable(true);
				userInput.setDisable(false);
				btConnect.setText("Connect");
			}
		});
		
		userInput.setOnAction(ae -> {
			if(!userInput.getText().equals("")) {
				btConnect.setDisable(false);
				username = userInput.getText();
			}
		});
		userInput.setPromptText("Type your username...");
		
		Region space = new Region();
		HBox.setHgrow(space, Priority.ALWAYS);
		
		HBox topPane = new HBox(10);
		topPane.getChildren().addAll(userInput, space, btConnect);
		
		ScrollPane scrollPane = new ScrollPane();
		BorderPane.setMargin(scrollPane, new Insets(10, 0, 10, 0));
		scrollPane.setPadding(new Insets(10, 10, 10, 10));
		scrollPane.setContent(chatPane);
		scrollPane.vvalueProperty().bind(chatPane.heightProperty());
		
		chatInput.setOnAction(ae -> addMessage());
		chatInput.setPromptText("Type a message...");
		chatInput.setDisable(true);
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setTop(topPane);
		pane.setCenter(scrollPane);
		pane.setBottom(chatInput);
		
		Scene scene = new Scene(pane, 350, 500);
		scene.getStylesheets().add("style.css");
		
		stage.setScene(scene);
		stage.setMinWidth(300);
		stage.getIcons().add(new Image("chat.png"));
		stage.setTitle("JChat Client");
		stage.show();
	}
	
	@Override
	public void stop() throws Exception {
		client.disconnect();
	}
	
	private void addMessage() {
		String text = chatInput.getText();
		if(!text.equals("")) {
			chatInput.setText("");
			Message message = new Message(new model.Message(username, text));
			chatPane.getChildren().addAll(message);
			client.send(username, text);
		}
	}
	
	private class Message extends VBox {
		
		public Message(model.Message msg, boolean in) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE yyyy-MM-dd HH:mm");
			String time = LocalDateTime.now().format(formatter);
			
			Label timeLabel = new Label(time);
			timeLabel.getStyleClass().add("time-label");
			
			Label userLabel = new Label(msg.getUser());
			userLabel.getStyleClass().add("user-label");
			
			HBox srcPane = new HBox(5);
			srcPane.getChildren().addAll(timeLabel, userLabel);
			
			Label msgLabel = new Label(msg.getMessage());
			
			this.getChildren().addAll(srcPane, msgLabel);
		}
		public Message(model.Message msg) {
			this(msg, false);
		}
	}

	@Override
	public void inform(Object obj) {
		model.Message msg = (model.Message) obj;
		chatPane.getChildren().addAll(new Message(msg, true));
	}

}
