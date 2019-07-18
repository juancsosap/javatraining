package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TextFieldTemplatePane extends TemplatePane {
	
	private TextField textFieldIn, textFieldOut;
	
	public TextFieldTemplatePane() {
		super("TextField Template");
		
		textFieldIn = new TextField("Initial Value");
		textFieldIn.setPromptText("This TextField will be clean when press ENTER");
		textFieldIn.setMinSize(100, 50);
		textFieldIn.setOnAction(ae -> clean());
		
		textFieldOut = new TextField();
		textFieldOut.setPromptText("All that you type in the other TextField will copy here automatically");
		textFieldOut.setMinSize(100, 50);
		textFieldOut.setEditable(false);
		
		textFieldOut.textProperty().bind(textFieldIn.textProperty());
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(textFieldIn, textFieldOut);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private void clean() {
		textFieldIn.setText("");
	}

}
