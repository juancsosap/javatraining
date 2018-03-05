package model;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String user;
	private String message;
	
	public Message(String user, String message) {
		this.user = user;
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}

}
