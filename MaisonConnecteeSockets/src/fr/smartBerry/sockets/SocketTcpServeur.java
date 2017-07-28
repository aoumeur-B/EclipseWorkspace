package fr.smartBerry.sockets;
import java.io.IOException;
import java.net.ServerSocket;

public class SocketTcpServeur{
	private ServerSocket socketserver;
	public void demarrerServeur() {
		try {
		socketserver = new ServerSocket(2009);
		System.out.println("démarrage du serveur Java (avec Thread), port d'écoute");
		Thread t = new Thread(new SocketTcpThread(socketserver));
		t.start();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}	
}
