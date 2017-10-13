package client;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		new Client("localhost", 2020).connect();//connect with server
	}

}
	