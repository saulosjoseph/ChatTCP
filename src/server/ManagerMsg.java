package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import server.Server;

public class ManagerMsg implements Runnable {

		private Socket socket;
		private Server server;
		
		public ManagerMsg(Socket client, Server server) {
			this.socket = client;
			this.server = server;
		}

		//receive data from clients and send to all other clients
		public void run() {
			try{
				Scanner input = new Scanner(this.socket.getInputStream());
				while (input.hasNextLine()) {
					server.sendToClients(socket, this.socket.getInetAddress().getHostAddress() + ": " + input.nextLine());
				}
				System.out.println(this.socket.getInetAddress().getHostAddress() + " desconected.");
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated cat	ch block
				e.printStackTrace();
			}
		}
		
	}