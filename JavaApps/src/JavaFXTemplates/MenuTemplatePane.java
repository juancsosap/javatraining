package JavaFXTemplates;

import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class MenuTemplatePane extends TemplatePane {
	
	private MenuBar menuBar = new MenuBar();
	private Label menuLabel = new Label();
	
	private MenuItem biggerItem, smallerItem;
	private RadioMenuItem arialItem, georgiaItem;
	private CheckMenuItem boldItem, italicItem;
	
	private String font;
	private int size;
	private boolean isItalic, isBold;
	
	public MenuTemplatePane() {
		super("MenuBar Template");
		
		Menu fontMenu = new Menu("_Font");
		
		ToggleGroup fontGroup = new ToggleGroup();
		
		arialItem = new RadioMenuItem("_Arial");
		arialItem.setToggleGroup(fontGroup);
		arialItem.setSelected(true);
		arialItem.setOnAction(ae -> setLabel("Arial", size, isBold, isItalic));
		fontMenu.getItems().add(arialItem);
		
		georgiaItem = new RadioMenuItem("_Georgia");
		georgiaItem.setToggleGroup(fontGroup);
		georgiaItem.setOnAction(ae -> setLabel("Georgia", size, isBold, isItalic));
		fontMenu.getItems().add(georgiaItem);
		
		Menu styleMenu = new Menu("S_tyle");
		
		boldItem = new CheckMenuItem("_Bold");
		boldItem.setOnAction(ae -> setLabel(font, size, !isBold, isItalic));
		styleMenu.getItems().add(boldItem);
		
		styleMenu.getItems().add(new SeparatorMenuItem());
		
		italicItem = new CheckMenuItem("_Italic");
		italicItem.setOnAction(ae -> setLabel(font, size, isBold, !isItalic));
		styleMenu.getItems().add(italicItem);
		
		Menu sizeMenu = new Menu("_Size");
		
		biggerItem = new MenuItem("_Bigger");
		biggerItem.setOnAction(ae -> setLabel(font, size+1, isBold, isItalic));
		sizeMenu.getItems().add(biggerItem);

		smallerItem = new MenuItem("S_maller");
		smallerItem.setOnAction(ae -> setLabel(font, size-1, isBold, isItalic));
		sizeMenu.getItems().add(smallerItem);

		menuBar.getMenus().addAll(fontMenu, sizeMenu, styleMenu);
		
		setLabel("Arial", 30, false, false);
		
		BorderPane layout = new BorderPane();
		layout.setTop(menuBar);
		layout.setCenter(menuLabel);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
		
	private void setLabel(String font, int size, boolean isBold, boolean isItalic) {
		this.font = font;
		this.size = size;
		this.isBold = isBold;
		this.isItalic = isItalic;
		
		FontPosture posture = isItalic ? FontPosture.ITALIC : FontPosture.REGULAR;
		FontWeight weight = isBold ? FontWeight.BOLD : FontWeight.NORMAL;
		Font labelFont = Font.font(font, weight, posture, size);
		
		menuLabel.setFont(labelFont);
		String italic = isItalic ? "Italic" : "Regular";
		String bold = isBold ? "Bold" : "Normal";
		String text = font + " : " + size + " : " + bold + " : " + italic;
		menuLabel.setText(text);

		smallerItem.setDisable(size == 20);
		biggerItem.setDisable(size == 40);
	}

}