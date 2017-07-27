package fr.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

	public void envoiJson(){
		Socket socket;
		BufferedReader in; //permet de lire les données envoyé par le serveur
		PrintWriter out; //ecriture sur le flux de donnée (envoi par l'élément Socket)

		try {
				//Connexion au serveur
	            System.out.println("Demande de connexion");
				socket = new Socket("localhost",2009); //Socket(adresse_serveur, port_serveur)
				
				//Envoi d'un string
		        System.out.println("envoi message de test");
		        out = new PrintWriter(socket.getOutputStream());
		        out.println("Client : Test");
		        out.flush();
		        
		        //reception message
		        in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
				String message_serveur = in.readLine();
		        System.out.println(message_serveur);
		        
		        //envoie string
		        System.out.println("envoi message fermeture connexion");
		        out.println("Client : je ferme la connection !!!");
		        out.flush();   
		        System.out.println("fermeture du socket");
		        socket.close();
		       
		//Une erreur est généré lors d'un problème d'envoi/réception de donnée avec le serveur
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
