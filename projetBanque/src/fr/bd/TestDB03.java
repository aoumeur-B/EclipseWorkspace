package fr.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.banque.Compte;
import fr.banque.CompteASeuil;
import fr.banque.CompteRemunere;

public class TestDB03 {

	
	private static Compte compte;
	private static List<Compte> listCompte;
	
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
				    listCompte= new ArrayList<Compte>();
				    
					 try {
					      Class.forName(dbDriver);
					    } catch (Throwable e) {
					      e.printStackTrace();
					    }
					 
					    try {
							connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
						
							request = connection.createStatement();
							String idcompte="2";

							resultat = request.executeQuery("SELECT * from compte where utilisateurId="+idcompte);
							
							while (resultat.next()) {
								
								String libelle = resultat.getString("libelle");
								if(libelle.equals("Compte Courant")){
									compte= new Compte();
									compte.ajouter(resultat.getDouble("solde"));
								}else if(libelle.equals("Livret A")){
									compte= new CompteASeuil();
									compte.ajouter(resultat.getDouble("solde"));
								}else if(libelle.equals("Compte Remunéré")){
									compte= new CompteRemunere();
									compte.ajouter(resultat.getDouble("solde"));
								}
								listCompte.add(compte);
								}
					    	}catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}finally {
							      if (resultat != null) {
							          try {
							            resultat.close();
							          } catch (SQLException e) {
							            e.printStackTrace();
							          }
							        }
							        if (request != null) {
							          try {
							            request.close();
							          } catch (SQLException e) {
							            e.printStackTrace();
							          }
							        }
							        if (connection != null) {
							          try {
							            connection.close();
							          } catch (SQLException e) {
							            e.printStackTrace();
							          }
							        }
							      }

			
				System.out.println(listCompte.toString());
	}
}
