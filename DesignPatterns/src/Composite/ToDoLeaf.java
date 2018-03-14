package Composite;

public class ToDoLeaf implements IToDoList {

	private String text;
	
	public ToDoLeaf(String text) {
		this.text = text;
	}
	
	@Override
	public String getHTML() {
		text = "<input type='checkbox'>" + this.text + "<br>";
		return text;
	}

}
