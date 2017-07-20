package fr.bd;

import java.sql.*;

public class TestDB01 {

	public static void main(String[] args) {
		// Nom du driver pour acceder a la base de donnees.
		// Lire la documentation associee a sa base de donnees pour le connaitre
		final String dbDriver = "com.mysql.jdbc.Driver";
		// URL d'access a la base de donnees.
		final String dbUrl = "jdbc:mysql://localhost:3306/banque";
		// Login d'access a la base de donnees.
		final String dbLogin = "root";
		// Mot de passe d'access a la base de donnees.
		final String dbPwd = "root";
		
		Connection connection = null;
	    Statement request = null;
	    ResultSet resultat = null;
	    
		 try {
		      Class.forName(dbDriver);
		    } catch (Throwable e) {
		      e.printStackTrace();
		    }
		 
		    try {
				connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
			
				request = connection.createStatement();

				resultat = request.executeQuery("SELECT * from utilisateur");
		    
				while (resultat.next()) {
					String nom = resultat.getString("nom");
					String prenom = resultat.getString("prenom");
					System.out.println("nom:"+nom + " " +"prénom: "+ prenom); 
					}
		    	}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
