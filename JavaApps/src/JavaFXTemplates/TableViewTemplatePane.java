package JavaFXTemplates;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TableViewTemplatePane extends TemplatePane {
	
	private TableView<Person> tableView = new TableView<>();
	private TextField nameInput, surnameInput, ageInput;
	
	@SuppressWarnings("unchecked")
	public TableViewTemplatePane() {
		super("TableView Template");
		
		TableColumn<Person, String> nameColum = new TableColumn<>("Name");
		nameColum.setMinWidth(150);
		nameColum.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Person, String> surnameColum = new TableColumn<>("Surname");
		surnameColum.setMinWidth(150);
		surnameColum.setCellValueFactory(new PropertyValueFactory<>("surname"));
		
		TableColumn<Person, Integer> ageColum = new TableColumn<>("Age");
		ageColum.setMinWidth(150);
		ageColum.setCellValueFactory(new PropertyValueFactory<>("age"));
		
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		surnameInput = new TextField();
		surnameInput.setPromptText("Surname");
		surnameInput.setMinWidth(100);
		
		ageInput = new TextField();
		ageInput.setPromptText("Age");
		ageInput.setMinWidth(50);
		
		Button addButton = new Button("Add");
		addButton.setMinWidth(40);
		addButton.setOnAction(ae -> addRegister());
		
		Button delButton = new Button("Del");
		delButton.setMinWidth(40);
		delButton.setOnAction(ae -> delRegister());
		
		HBox cmdLayout = new HBox();
		cmdLayout.setPadding(new Insets(10, 10, 10, 10));
		cmdLayout.setSpacing(10);
		cmdLayout.getChildren().addAll(nameInput, surnameInput, ageInput, addButton, delButton);
		
		tableView.setItems(getSampleData());
		tableView.getColumns().addAll(nameColum, surnameColum, ageColum);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(tableView, cmdLayout);
		layout.setPadding(new Insets(50, 50, 50, 50));
		
		setCenter(layout);
	}
	
	private ObservableList<Person> getSampleData(){
		ObservableList<Person> people = FXCollections.observableArrayList();
		
		people.add(new Person("Juan", "Sousa", 35));
		people.add(new Person("Luis", "Rozas", 20));
		people.add(new Person("Paco", "Perez", 15));
		people.add(new Person("Omar", "Prada", 55));
		people.add(new Person("Jose", "Pinto", 45));
		people.add(new Person("Pepe", "Avila", 70));
		
		return people;
	}
	
	private void addRegister() {
		Person newPerson = new Person();
		newPerson.setName(nameInput.getText());
		newPerson.setSurname(surnameInput.getText());
		newPerson.setAge(Integer.parseInt(ageInput.getText()));
		tableView.getItems().add(newPerson);
		nameInput.clear();
		surnameInput.clear();
		ageInput.clear();
	}
	
	private void delRegister() {
		ObservableList<Person> peopleSelected, people;
		people = tableView.getItems();
		peopleSelected = tableView.getSelectionModel().getSelectedItems();
		peopleSelected.forEach(people::remove);
	}

}