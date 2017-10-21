package client;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

import ui.ChatUI;

public class ReceiveFromServer implements Runnable{

	private InputStream input;
	private ChatUI ui;
	private String msg;

	public ReceiveFromServer(Socket socket, ChatUI ui) {
		try {
			this.input = socket.getInputStream();
			this.ui = ui;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try (Scanner s = new Scanner(this.input)){
				while(s.hasNextLine()) {
				this.msg = s.nextLine();
				ui.printChat(msg);
			}
		}
	}

}