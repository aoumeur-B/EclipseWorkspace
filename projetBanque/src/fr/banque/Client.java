package fr.banque;

import java.util.Hashtable;
import java.util.Map;

public class Client {

		
		private String nom;
		private String prenom;
		private int age;
		private int numeroClient;
		private static int compteurNumero=1;
		private Map<Integer,Compte> listCompte;
		private final int nbreCompteMax = 5;
		
		
		
		public Client(){
			this.setNumero(compteurNumero);
			compteurNumero++;
			 this.listCompte = new Hashtable<Integer,Compte>();
		}
		public Client(String nom, String prenom, int age) {
			this.setNumero(compteurNumero);
			compteurNumero++;
			this.listCompte = new Hashtable<Integer,Compte>();
			this.nom= nom;
			this.prenom=prenom;
			this.age=age;
		}

		
		public void ajouterCompte(Compte unCompte) throws BanqueException{

			if(this.listCompte.size()<=nbreCompteMax){
				this.listCompte.put(unCompte.getNumero(), unCompte);
				return;
			}
			throw new BanqueException("Le nbre maximum de comptes est atteint pour: "+this.getNom()+" "+this.getPrenom());
		}
		
		
		public Compte getCompte(int numeroCompte ){
			
			if(this.listCompte.containsKey(numeroCompte)){
				return this.listCompte.get(numeroCompte); 
			}else{
				System.out.println("Monsieur/Madame: "+this.getNom()+" "+this.getPrenom()+ "le compte numéro"+ numeroCompte);
				return null;
			}
		}
		
		public Compte[] getComptes() {
			return this.getComptes();
		}
		
		
		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getNumero() {
			return numeroClient;
		}

		private void setNumero(int numero) {
			this.numeroClient = numero;
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Client [nom=");
			builder.append(nom);
			builder.append(", prenom=");
			builder.append(prenom);
			builder.append(", age=");
			builder.append(age);
			builder.append(", numeroClient=");
			builder.append(numeroClient);
			builder.append(", listCompte=");
			builder.append(listCompte.toString());
			builder.append("]");
			return builder.toString();
	
		}
}
