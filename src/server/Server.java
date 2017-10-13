package server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	
	private int port;
	private List<Socket> clients;
	
	public Server(int porta) {
		this.port = porta;
		this.clients = new ArrayList<>();
	}
	
	public void run() throws IOException {
		try(ServerSocket server = new ServerSocket(this.port)){
			System.out.println("Waiting...");			
			while(true) {
				Socket client = server.accept();
				clients.add(client);
				System.out.println(client.getInetAddress().getHostAddress() + " Conected.");
				ReceiveFromClients receive = new ReceiveFromClients(client, this);
				new Thread(receive).start();
			}			
		}
	}
	
	public void sendToClients(Socket client, String msg) throws IOException {
		for(Socket c : clients) {
			if(!c.equals(client)){
				PrintStream ps = new PrintStream(c.getOutputStream());
				ps.println(msg);
			}
		}
	}
	
}