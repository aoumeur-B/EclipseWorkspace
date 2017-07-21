package fr.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.banque.Client;
import fr.banque.Compte;
import fr.banque.CompteASeuil;
import fr.banque.CompteRemunere;
import fr.banque.Operation;

public class TestDB {

	private static Client client;
	private static List<Client> listClient;
	private static Compte compte;
	private static List<Compte> listCompte;
	private static Operation operation;
	private static List<Operation> listOperation;
	Connection connection = null;
	Statement request = null;
	ResultSet resultat = null;

	public void seConnecter(String unLogin, String unPassword, String unUrl) {

		// Nom du driver pour acceder a la base de donnees.
		// Lire la documentation associee a sa base de donnees pour le connaitre
		final String dbDriver = "com.mysql.jdbc.Driver";
		// URL d'access a la base de donnees.
		final String dbUrl = unUrl; // "jdbc:mysql://localhost:3306/banque";
		// Login d'access a la base de donnees.
		final String dbLogin = unLogin;
		// Mot de passe d'access a la base de donnees.
		final String dbPwd = unPassword;

		try {
			Class.forName(dbDriver);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void seDeconnecter() {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Client> recupererClients() {

		listClient = new ArrayList<Client>();
		try {
			request = connection.createStatement();

			resultat = request.executeQuery("SELECT * from utilisateur");

			while (resultat.next()) {
				client = new Client();
				client.setNom(resultat.getString("nom"));
				client.setPrenom(resultat.getString("prenom"));
				listClient.add(client);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		return listClient;
	}

	
	//FIXME
	public List<Compte> recupererComptes(int unIdClient) {
		listCompte = new ArrayList<Compte>();
		try {

			request = connection.createStatement();

			resultat = request.executeQuery("SELECT * from compte where utilisateurId="+unIdClient);

			while (resultat.next()) {

				String libelle = resultat.getString("libelle");
				if (libelle.equals("Compte Courant")) {
					compte = new Compte();
					compte.ajouter(resultat.getDouble("solde"));
				} else if (libelle.equals("Livret A")) {
					compte = new CompteASeuil();
					compte.ajouter(resultat.getDouble("solde"));
				} else if (libelle.equals("Compte Remunéré")) {
					compte = new CompteRemunere();
					compte.ajouter(resultat.getDouble("solde"));
				}
				listCompte.add(compte);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

		}
		return listCompte;
	}

	//FIXME
	public List<Operation> recupererOperations(int unIdCompte) {
		 listOperation= new ArrayList<Operation>();
		 try {		
				request = connection.createStatement();

				resultat = request.executeQuery("SELECT * from operation where compteId="+unIdCompte);
				
				while (resultat.next()) {
					operation = new Operation();
					operation.setId(resultat.getInt("id"));;
					operation.setLibelle(resultat.getString("libelle"));
					operation.setMontant(resultat.getDouble("montant"));
					operation.setCompteId(resultat.getInt("compteId"));
					operation.setDate(resultat.getDate("date"));

					listOperation.add(operation);
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

	return listOperation;
	}
}
