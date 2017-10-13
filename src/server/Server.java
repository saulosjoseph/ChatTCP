package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private int port;
	
	public Server(int porta) {
		this.port = porta;
	}
	
	public void run() throws IOException {
		try(ServerSocket server = new ServerSocket(this.port)){
			System.out.println("Waiting...");			
			while(true) {
				Socket client = server.accept();
				System.out.println(client.getInetAddress().getHostAddress() + " Conected.");
				ReceiveFromClients receive = new ReceiveFromClients(client);
				new Thread(receive).start();
			}			
		}
	}
	
}