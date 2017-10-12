package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

   public static void main(String[] args) throws UnknownHostException, IOException {

     Socket client = new Socket("127.0.0.1", 12345);
     System.out.println("Conected");     

     Scanner input = new Scanner(System.in);
     PrintStream output = new PrintStream(client.getOutputStream());
     while (input.hasNextLine()) {
       output.println(input.nextLine());
     }

     output.close();
     input.close();
     client.close();

   }

 }