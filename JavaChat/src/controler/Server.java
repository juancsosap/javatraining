package controler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javafx.concurrent.Task;

public class Server extends Task<Void> {

	private ServerSocket serverSocket;
	
	private boolean enable = true;
	private boolean running = false;
	
	private ArrayList<Socket> clients;
	private Informable src;
	
	public Server(Informable src) {
		this.src = src;
		enable = true;
	}
	
	public void startServer() {
		try {
			this.run();
		} catch (Exception e) {
			System.out.println("Some error with the Server");
		}
	}
	
	@Override
	protected Void call() throws Exception {
		System.out.println("Server Starting...");
		try {
			serverSocket = new ServerSocket(194);
			
			while(enable) {
				System.out.println("Server Started");
				running = true;
				
				Socket socket = serverSocket.accept();
				src.inform(socket);
				
				clients.add(socket);
				
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				
				try {
					model.Message message = (model.Message) input.readObject();
					System.out.println("Reciving Message from " + message.getUser() + 
					                   ": " + message.getMessage());
					for(Socket skt: clients) {
						if(!skt.equals(socket)) {
							ObjectOutputStream output = new ObjectOutputStream(skt.getOutputStream());
							output.writeObject(message);
							output.close();
						}
					}
				} catch (ClassNotFoundException e2) {
					System.out.println("Error Reciving Message");
				}
				
				input.close();
			}
			
			for(Socket skt: clients) {
				if(skt != null)
					if(skt.isConnected())
						skt.close();
			}
			
			serverSocket.close();
		} catch (IOException e1) {
			if(running)
				System.out.println("Error starting the Server");
			else
				System.out.println("Stopping the Server...");
		} finally {
			running = false;
		}
		return null;
	}
	
	public void disable() {
		this.running = false;
		this.enable = false;
		try {
			if(serverSocket != null)
				serverSocket.close();
		} catch (IOException e) {
			System.out.println("Error stopping the Server");
		}
	}

}
