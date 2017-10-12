package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(12345); //abre uma porta e espera uma conexão
		System.out.println("Waiting...");

		Socket client = server.accept(); //aceita uma conexão
		System.out.println("New conection: " + client.getInetAddress().getHostAddress());

		ReceiveFromClients teste = new ReceiveFromClients(client, server);

		//fecha a conexão         
		client.close();
		server.close();

	}
}