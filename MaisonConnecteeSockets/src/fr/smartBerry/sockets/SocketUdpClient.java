package fr.smartBerry.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.json.simple.JSONObject;

public class SocketUdpClient implements Runnable {
	String name = "";
	long sleepTime = 1000;

	public SocketUdpClient(String pName) {
		name = pName;
	}

	public void run() {
		// Initialisation de variables fictives pour un envoie de donn�es en JSON
		double temperature = 30.35;
		int ampoule = 1;
		int cycle_vanne = 3;

		//cr�ation d'un json pour envoi
		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("ampoule", ampoule);
		json.put("cycle d'arrosage", cycle_vanne);
		json.put("temperature", temperature);

		//conversion avant envoi
		byte[] buffer = json.toJSONString().getBytes();

		try {
			// On initialise la connexion client
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress adresse = InetAddress.getByName("127.0.0.1");

			
			// On cr�e le paquet � envoyer
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, adresse, 2345);
			packet.setData(buffer);

			// On envoie au serveur
			clientSocket.send(packet);
			System.out.println("paquet envoyé");
			clientSocket.close();

			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
