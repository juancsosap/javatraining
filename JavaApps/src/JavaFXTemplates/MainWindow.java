package JavaFXTemplates;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow extends Application {
	
	private Pane bodyLayout;
	
	private BorderPane mainLayout = new BorderPane();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("JavaFX Templates");
		
		Menu controlMenu = new Menu("_Controls");
		
		Pane labelLayout = new LabelTemplatePane();
		MenuItem labelItem = new MenuItem("Label");
		labelItem.setOnAction(ae -> setPane(labelLayout));
		controlMenu.getItems().add(labelItem);
		
		Pane buttonLayout = new ButtonTemplatePane();
		MenuItem buttonItem = new MenuItem("Button");
		buttonItem.setOnAction(ae -> setPane(buttonLayout));
		controlMenu.getItems().add(buttonItem);
		
		Pane textFieldLayout = new TextFieldTemplatePane();
		MenuItem textFieldItem = new MenuItem("TextField");
		textFieldItem.setOnAction(ae -> setPane(textFieldLayout));
		controlMenu.getItems().add(textFieldItem);

		Pane passwordFieldLayout = new PasswordFieldTemplatePane();
		MenuItem passwordFieldItem = new MenuItem("PasswordField");
		passwordFieldItem.setOnAction(ae -> setPane(passwordFieldLayout));
		controlMenu.getItems().add(passwordFieldItem);

		Menu complexControlMenu = new Menu("Comple_x Controls");
		
		Pane comboBoxLayout = new ComboBoxTemplatePane();
		MenuItem comboBoxItem = new MenuItem("ComboBox");
		comboBoxItem.setOnAction(ae -> setPane(comboBoxLayout));
		complexControlMenu.getItems().add(comboBoxItem);

		complexControlMenu.getItems().add(new SeparatorMenuItem());
		
		Pane checkBoxLayout = new CheckBoxTemplatePane();
		MenuItem checkBoxItem = new MenuItem("CheckBox");
		checkBoxItem.setOnAction(ae -> setPane(checkBoxLayout));
		complexControlMenu.getItems().add(checkBoxItem);

		Pane radioButtonLayout = new RadioButtonTemplatePane();
		MenuItem radioButtonItem = new MenuItem("RadioButton");
		radioButtonItem.setOnAction(ae -> setPane(radioButtonLayout));
		complexControlMenu.getItems().add(radioButtonItem);

		complexControlMenu.getItems().add(new SeparatorMenuItem());
		
		Pane listViewLayout = new ListViewTemplatePane();
		MenuItem listViewItem = new MenuItem("ListView");
		listViewItem.setOnAction(ae -> setPane(listViewLayout));
		complexControlMenu.getItems().add(listViewItem);

		Pane treeViewLayout = new TreeViewTemplatePane();
		MenuItem treeViewItem = new MenuItem("TreeView");
		treeViewItem.setOnAction(ae -> setPane(treeViewLayout));
		complexControlMenu.getItems().add(treeViewItem);

		Pane tableViewLayout = new TableViewTemplatePane();
		MenuItem tableViewItem = new MenuItem("TableView");
		tableViewItem.setOnAction(ae -> setPane(tableViewLayout));
		complexControlMenu.getItems().add(tableViewItem);

		complexControlMenu.getItems().add(new SeparatorMenuItem());
		
		Pane menuBarLayout = new MenuTemplatePane();
		MenuItem menuBarItem = new MenuItem("MenuBar");
		menuBarItem.setOnAction(ae -> setPane(menuBarLayout));
		complexControlMenu.getItems().add(menuBarItem);
		
		Menu layoutMenu = new Menu("_Layouts");
		
		Pane borderPaneLayout = new BorderPaneTemplatePane();
		MenuItem borderPaneItem = new MenuItem("BorderPane");
		borderPaneItem.setOnAction(ae -> setPane(borderPaneLayout));
		layoutMenu.getItems().add(borderPaneItem);
		
		Pane gridPaneLayout = new GridPaneTemplatePane();
		MenuItem gridPaneItem = new MenuItem("GridPane");
		gridPaneItem.setOnAction(ae -> setPane(gridPaneLayout));
		layoutMenu.getItems().add(gridPaneItem);
		
		Pane stackPaneLayout = new StackPaneTemplatePane();
		MenuItem stackPaneItem = new MenuItem("StackPane");
		stackPaneItem.setOnAction(ae -> setPane(stackPaneLayout));
		layoutMenu.getItems().add(stackPaneItem);
		
		Pane anchorPaneLayout = new AnchorPaneTemplatePane();
		MenuItem anchorPaneItem = new MenuItem("AnchorPane");
		anchorPaneItem.setOnAction(ae -> setPane(anchorPaneLayout));
		layoutMenu.getItems().add(anchorPaneItem);
		
		layoutMenu.getItems().add(new SeparatorMenuItem());
		
		Pane vboxLayout = new VBoxTemplatePane();
		MenuItem vboxItem = new MenuItem("VBox");
		vboxItem.setOnAction(ae -> setPane(vboxLayout));
		layoutMenu.getItems().add(vboxItem);
		
		Pane hboxLayout = new HBoxTemplatePane();
		MenuItem hboxItem = new MenuItem("HBox");
		hboxItem.setOnAction(ae -> setPane(hboxLayout));
		layoutMenu.getItems().add(hboxItem);
		
		layoutMenu.getItems().add(new SeparatorMenuItem());
		
		Pane accordionLayout = new AccordionTemplatePane();
		MenuItem accordionItem = new MenuItem("Accordion");
		accordionItem.setOnAction(ae -> setPane(accordionLayout));
		layoutMenu.getItems().add(accordionItem);
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(controlMenu, complexControlMenu, layoutMenu);
		
		bodyLayout = labelLayout;
		mainLayout.setTop(menuBar);
		setPane(labelLayout);
		
		Scene mainScene = new Scene(mainLayout, 600, 300);
		mainScene.getStylesheets().add("style.css");
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		mainStage.show();
		
	}
	
	private void setPane(Pane layout) {
		bodyLayout.setVisible(false);
		layout.setVisible(true);
		bodyLayout = layout;
		mainLayout.setCenter(bodyLayout);
	}

}
