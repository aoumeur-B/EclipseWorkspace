package fr.banque;

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
		
		
		 try {
		      Class.forName(dbDriver);
		    } catch (Throwable e) {
		      e.printStackTrace();
		    }

		 
		 
		 	Connection connection = null;
		    Statement request = null;
		    ResultSet resultat = null;

		    try {
		      connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);

		
	}
}
