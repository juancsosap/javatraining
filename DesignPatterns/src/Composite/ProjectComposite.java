package Composite;

import java.util.List;

public class ProjectComposite implements IToDoList {

	private String title;
	
	List<IToDoList> toDos;
	
	public ProjectComposite(String title, List<IToDoList> toDos) {
		this.title = title;
		this.toDos = toDos;
	}
	
	
	@Override
	public String getHTML() {
		String text = "<input type='checkbox'>" + this.title + "\n";
		text += "<ul>\n";
		for(IToDoList toDo : toDos)
			text += "<li>" + toDo.getHTML() + "</li>\n";
		text += "</ul>\n";
		return text;
	}

}
