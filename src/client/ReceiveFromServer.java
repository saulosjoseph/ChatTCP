package client;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveFromServer implements Runnable{

	private InputStream input;;

	public ReceiveFromServer(Socket socket) {
		try {
			this.input = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try (Scanner s = new Scanner(this.input)){
				while(s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
		}
	}

}