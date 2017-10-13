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

	public void run() throws IOException {
		Socket client = new Socket(host, port);
		Scanner input = new Scanner(System.in);
		PrintStream output = new PrintStream(client.getOutputStream());
		System.out.println("Conected");

		ReceiveFromServer receive = new ReceiveFromServer(client.getInputStream());
		new Thread(receive).start();

		while (input.hasNextLine()) {
			output.println(input.nextLine());
		}

		output.close();
		input.close();
		client.close();
	}

}