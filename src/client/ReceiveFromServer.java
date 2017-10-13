package client;

import java.io.InputStream;
import java.util.Scanner;

public class ReceiveFromServer implements Runnable {

	private InputStream server;

	public ReceiveFromServer(InputStream server) {
		this.server = server;
	}

	public void run() {
		try (Scanner s = new Scanner(this.server)){
				while(s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
		}
	}

}
