import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;


public class JavaSocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		BufferedReader in;
		PrintWriter out;

		try {
			//initialisation du serveur d'écoute
			socketserver = new ServerSocket(2009);
			System.out.println("Serveur à l'écoute du port : " + socketserver.getLocalPort());
			socketduserveur = socketserver.accept(); 
			System.out.println("Client connecté");
			
			//reception de la reponse client
			in = new BufferedReader (new InputStreamReader (socketduserveur.getInputStream()));
			String message_client = in.readLine();
	        System.out.println(message_client);
	        
	      //envoie message pour le client
	        System.out.println("envoi d'un message de confirmation au client");
	        out = new PrintWriter(socketduserveur.getOutputStream());
	        out.println("Serveur : ok reçu !!!");
	        out.flush();
	        
	           //reception de la reponse client
			message_client = in.readLine();
	        System.out.println(message_client);
	        
	        System.out.println("Fermeture du socket serveur");
		    socketserver.close();
		    System.out.println("Fermeture du socket de communication serveur");
		    socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
