import java.io.IOException;
import java.net.ServerSocket;

public class JavaSocketServerThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket socketserver;
		try {
		socketserver = new ServerSocket(2009);
		System.out.println("démarrage du serveur Java (avec Thread), port d'écoute");
		Thread t = new Thread(new ConnexionArduino(socketserver));
		t.start();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
