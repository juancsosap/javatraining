package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridPaneTemplatePane extends TemplatePane {
	
	public GridPaneTemplatePane() {
		super("GridPane Template");
		
		GridPane layout = new GridPane();
		layout.getStylesheets().add("layoutStyle.css");
		layout.setVgap(15);
		layout.setHgap(20);
		
		Label[] gridLabel = new Label[12];
		
		for(int i=0; i<gridLabel.length; i++) {
			int row = i%2;
			int column = i/2;
			
			gridLabel[i] = new Label("(" + row + "," + column + ")");
			gridLabel[i].setMinWidth(100);
			gridLabel[i].setMinSize(60, 60);
			GridPane.setConstraints(gridLabel[i], column, row);
			layout.getChildren().add(gridLabel[i]);
		}
				
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}

}
