package fr.smartBerry.main;

import fr.smartBerry.sockets.SocketUdpThread;

public class Main {

	public static void main(String[] args) {

		int port = 2345 ;
		String name = "arduino 1";
		
		// serveur
		SocketUdpThread.demarrerServeur(port);
		
		// client
		SocketUdpThread.envoyerClient(name);
		
	}

}
