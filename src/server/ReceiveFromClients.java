package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ReceiveFromClients implements Runnable {

	private Socket c;
	private Server s;
	
	public ReceiveFromClients(Socket client, Server server) {
		this.c = client;
		this.s = server;
	}

	public void run() {
		try(Scanner input = new Scanner(this.c.getInputStream())){
			while (input.hasNextLine()) {
				//System.out.println(this.c.getInetAddress().getHostAddress() + ": " + input.nextLine());
				s.sendToClients(c, this.c.getInetAddress().getHostAddress() + ": " + input.nextLine());
			}
			System.out.println(this.c.getInetAddress().getHostAddress() + " Desconected.");
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}