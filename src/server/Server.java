package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

   public static void main(String[] args) throws IOException {

     ServerSocket server = new ServerSocket(12345); //abre uma porta e espera uma conexão
     System.out.println("Waiting...");
     
     Socket client = server.accept(); //aceita uma conexão
     System.out.println("New conection: " + client.getInetAddress().getHostAddress());
     
     Scanner input = new Scanner(client.getInputStream()); //lê as informações enviadas pelo cliente
     while (input.hasNextLine()) {
       System.out.println(client.getInetAddress().getHostAddress() + ": " + input.nextLine());
     }
     
     //fecha a conexão
     input.close();
     server.close();
     client.close();

   }

 }