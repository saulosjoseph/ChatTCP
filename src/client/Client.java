package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private int port;
	private String host;

	public Client(String host, int port) {
		this.port = port;
		this.host = host;
	}

	public void connect() throws IOException {
		Socket client = new Socket(host, port); //create a server connection
		System.out.println("Conected");
		Scanner input = new Scanner(System.in);
		PrintStream send = new PrintStream(client.getOutputStream()); //add functions to socket

		ReceiveFromServer receive = new ReceiveFromServer(client.getInputStream());
		new Thread(receive).start();		

		while (input.hasNextLine()) {
			send.println(input.nextLine());//send to server
		}
		
		input.close();
		client.close();

	}

}