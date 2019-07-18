package controler;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	
	private ClientReception reciveTask;
	private Socket socket;
	
	private Informable src;
	
	public Client(Informable src) {
		this.src = src;
	}
	
	public void send(String user, String msg) {
		System.out.println("Sending Message: " + msg);
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			model.Message message = new model.Message(user, msg);
			output.writeObject(message);
			output.close();
		} catch (IOException e) {
			System.out.println("Error enviando el mensaje: " + msg);
		}
	}
	
	public void connect() {
		try {
			socket = new Socket("localhost", 194);
			reciveTask = new ClientReception(src, socket);
			reciveTask.run();
			System.out.println("Connected to the Server");
		} catch (Exception e) {
			System.out.println("The Server could not be contacted");
		}
	}
	
	public void disconnect() {
		try {
			if(socket != null) {
				socket.close();
				System.out.println("Disconnected from the Server");
			}
		} catch (IOException e) {
			System.out.println("Error disconnecting from the Server");
		}
	}
	
}
