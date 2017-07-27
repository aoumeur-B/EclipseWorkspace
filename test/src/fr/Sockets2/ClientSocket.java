package fr.Sockets2;

import java.io.IOException;
import java.net.Socket;

public class ClientSocket {
	
public static void main(String[] zero){
		
		Socket socket;
		try {
		socket = new Socket("localhost",2009);
		socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
