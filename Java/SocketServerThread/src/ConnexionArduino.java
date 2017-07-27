import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnexionArduino implements Runnable{
	private ServerSocket socketserver;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	ConnexionArduino(ServerSocket socketserver){
		this.socketserver = socketserver;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				socket = socketserver.accept(); // Un client se connecte on l'accepte
	            System.out.println("Arduino Connecté");
	            
				in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		        out = new PrintWriter(socket.getOutputStream());
		        
				String message_client = in.readLine();
		        System.out.println(message_client);
		        
		        out.println("Serveur : ok receptionné !!!");
		        out.flush();
		        
				message_client = in.readLine();
		        System.out.println(message_client);
		        
		        System.out.println("Fermeture du socket");
	            socket.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
}
