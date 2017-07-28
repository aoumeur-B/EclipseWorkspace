package fr.smartBerry.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SocketUdpServer implements Runnable {
	private DatagramSocket server;

	public SocketUdpServer(DatagramSocket server) {
		this.server = server;
	}

	@Override
	public void run() {

		try {
			while (true) {

				// On prépare le paquet à recevoir
				byte[] buffer = new byte[8192];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				server.receive(packet); // On attend la recpetion d'un paquet (cette methode bloque le thread jusqu'� reception de quelquechose)

				// on récupère le contenu du paquet reçu et on l'affiche
				String messageClient = new String(packet.getData(), 0, packet.getLength()); // conversion des bytes re�us en string
				System.out.println("Reçu de la part de " + packet.getAddress() + " sur le port " + packet.getPort() + " : ");
				System.out.println(messageClient);

				// On reconstruit un json à partir du message
				try {
					JSONParser parser = new JSONParser();
					Object obj = parser.parse(messageClient);
					JSONObject json = (JSONObject) obj;
					String str = (String) json.get("name");
					System.out.println(str);
				} catch (ParseException pe) {
					System.out.println("position: " + pe.getPosition());
					System.out.println(pe);
				}

				// On réinitialise la taille du datagramme, pour les futures réceptions
				packet.setLength(buffer.length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}