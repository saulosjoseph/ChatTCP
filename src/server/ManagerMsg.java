package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ManagerMsg implements Runnable {

	private Socket c;
	private Server s;
	
	public ManagerMsg(Socket client, Server server) {
		this.c = client;
		this.s = server;
	}

	//receive data from clients and send to all other clients
	public void run() {
		try(Scanner input = new Scanner(this.c.getInputStream())){
			while (input.hasNextLine()) {
				s.sendToClients(c, this.c.getInetAddress().getHostAddress() + ": " + input.nextLine());
			}
			System.out.println(this.c.getInetAddress().getHostAddress() + " desconected.");
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}