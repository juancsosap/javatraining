package controler;

import java.io.ObjectInputStream;
import java.net.Socket;

import javafx.concurrent.Task;

public class ClientReception extends Task<Void> {

	private boolean enable = true;
	
	private Informable src;
	private Socket socket;
	
	public ClientReception(Informable src, Socket socket) {
		this.src = src;
		this.socket = socket;
	}
	
	@Override
	protected Void call() throws Exception {
		while(enable) {
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			
			model.Message message = (model.Message) input.readObject();
			src.inform(message);
			
			input.close();
		}
		return null;
	}
	
}
