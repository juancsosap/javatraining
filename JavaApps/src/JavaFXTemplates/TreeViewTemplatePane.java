package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;

public class TreeViewTemplatePane extends TemplatePane {
	
	private TreeView<String> treeView;
	private Label selectedItemLabel = new Label();
	
	public TreeViewTemplatePane() {
		super("TreeView Template");
		
		TreeItem<String> root = new TreeItem<>("Root");
		root.setExpanded(true);
		treeView = new TreeView<>(root);
		treeView.setShowRoot(false);
		treeView.getSelectionModel().selectedItemProperty()
		        .addListener((v, oldValue, newValue) -> {
			if(!newValue.getValue().equals("Root")) {
				selectedItemLabel.setText(newValue.getParent().getValue() + " -> " + newValue.getValue());
			}
		});
		
		TreeItem<String> languages = addBranch("Languages", root);
		addBranch("Java", languages);
		addBranch("Python", languages);
		addBranch("Ruby", languages);
		addBranch("Perl", languages);
		
		TreeItem<String> ides = addBranch("IDEs", root);
		addBranch("Eclipse", ides);
		addBranch("Netbeens", ides);
		addBranch("SublimeText", ides);
		addBranch("Visual Studio", ides);
		
		HBox layout = new HBox(50);
		layout.getChildren().addAll(treeView, selectedItemLabel);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private TreeItem<String> addBranch(String title, TreeItem<String> parent){
		TreeItem<String> treeItem = new TreeItem<>(title);
		treeItem.setExpanded(true);
		parent.getChildren().add(treeItem);
		return treeItem;
	}

}
