package JavaFXTemplates;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListViewTemplatePane extends TemplatePane {
	
	private ListView<String> listView = new ListView<>();
	
	public ListViewTemplatePane() {
		super("ListView Template");
		
		HBox hbox = new HBox(20);
		
		Label preferenceLabel = new Label("Choose two Preference:");
		
		Button doneButton = new Button("Done!");
		doneButton.setOnAction(ae -> validatePreferences());
		
		hbox.getChildren().addAll(preferenceLabel, doneButton);
		
		String[] preferences = {"Technology", "Health",
		                        "Fitness", "Science",
		                        "Food", "Travel",
		                        "Animals", "Flowers"};
		
		listView.getItems().addAll(preferences);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(hbox, listView);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private void validatePreferences() {
		ObservableList<String> prefs = listView.getSelectionModel().getSelectedItems(); 
		if(prefs.size() > 2)
			listView.getSelectionModel().clearSelection();
	}

}
