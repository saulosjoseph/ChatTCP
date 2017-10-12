package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ReceiveFromClients {
	
	public ReceiveFromClients(Socket client, ServerSocket server) throws IOException {
		Scanner input = new Scanner(client.getInputStream()); //lê as informações enviadas pelo cliente
		while (input.hasNextLine()) {
			System.out.println(client.getInetAddress().getHostAddress() + ": " + input.nextLine());    	 
		}
		input.close();
	}
}
