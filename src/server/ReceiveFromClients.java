package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ReceiveFromClients implements Runnable {

	private Socket c;

	public ReceiveFromClients(Socket client) {
		this.c = client;
	}

	public void run() {
		try(Scanner input = new Scanner(this.c.getInputStream())){
			while (input.hasNextLine()) {
				System.out.println(this.c.getInetAddress().getHostAddress() + ": " + input.nextLine());
			}
			System.out.println(this.c.getInetAddress().getHostAddress() + " Desconected.");
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}