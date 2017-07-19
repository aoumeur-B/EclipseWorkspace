package exo6_Banque;

import java.util.Arrays;

public class Client {

	
	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private static int compteurNumero=1;
	private Compte[] comptes;
	private final int nbreCompteMax = 5;
	
	
	
	public Client(){
		this.setNumero(compteurNumero); 
		compteurNumero++;
		 this.comptes = new Compte[nbreCompteMax];
	}

	
	public void ajouterCompte(Compte unCompte){

		boolean comptePlein = true;
		for(int i=0; i< this.comptes.length;i++){
			if(this.comptes[i]==null){
				this.comptes[i] = unCompte;
				comptePlein = false;
			}
		}
		if(comptePlein){
			System.out.println("Le nbre maximum des compte est atteint pour: "+this.getNom()+" "+this.getPrenom());
		}
	}
	
	
	public Compte getCompte(int numeroCompte ){
		boolean compteTrouver = false;
		for(int i=0; i< this.comptes.length;i++){
			if(this.comptes[i].getNumero() == numeroCompte){
				compteTrouver = false;
				return this.comptes[i]; 
			}
		}
		if(!compteTrouver){
			System.out.println("Monsieur/Madame: "+this.getNom()+" "+this.getPrenom()+ "le compte numéro"+ numeroCompte);
		}
		return null;
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
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", soldes=");
		builder.append(Arrays.toString(comptes));
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
