package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	private int port;
	private Client client;
	private Socket socket;
	private PrintStream output;

	public Client(int port) {
		this.port = port;
	}

	public void connect(){
		
		try {
			
			this.socket = new Socket("localhost", port);
			System.out.println("Conected");	
			
			output = new PrintStream(socket.getOutputStream());

			//recebe do servidor e printa
			ReceiveFromServer receive = new ReceiveFromServer(this.socket);
			new Thread(receive).start();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //create a server connection	
	}

	public static void main(String[] args) throws IOException {
		new Client(2020).connect();//connect with server
	}

	public void send(String msg) {
		output.println(msg);
	}

	public void close() {
		this.client.close();
	}

}
