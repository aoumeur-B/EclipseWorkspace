package fr.smartBerry.sockets;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketUdpThread {

	
	public static void envoyerClient(String name) {

		Thread cli1 = new Thread(new SocketUdpClient(name));
		cli1.start();
	}

	public static void demarrerServeur(int port) {

		try {
			DatagramSocket server = new DatagramSocket(port);
			System.out.println("démarrage du serveur en UDP, port d'écoute : "+ port);
			Thread t = new Thread(new SocketUdpServer(server));
			t.start();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

}
