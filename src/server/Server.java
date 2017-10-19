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
	private Socket socket;

	public Server(int porta) {
		this.port = porta;
		this.clients = new ArrayList<>();
	}
	//create server, accept client and start thread to receive data
	public void start() throws IOException {
		try(ServerSocket server = new ServerSocket(this.port)){ 
			System.out.println("Waiting...");			
			while(true) {
				this.socket = server.accept();
				clients.add(socket);
				System.out.println(socket.getInetAddress().getHostAddress() + " Conected.");
				ManagerMsg receive = new ManagerMsg(socket, this);
				new Thread(receive).start();
			}			
		}
	}
	//receive data from client and send to all other clients
	public void sendToClients(Socket client, String msg) throws IOException {
		for(Socket i : clients) { //
			if(!i.equals(client)){
				PrintStream ps = new PrintStream(i.getOutputStream());
				ps.println(msg);
			}
		}
	}	

	public static void main(String[] args) throws IOException {
		new Server(2020).start(); //create a server
	}

}