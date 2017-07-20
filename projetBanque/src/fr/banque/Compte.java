package fr.banque;

public class Compte {
	private int numero;
	private double solde;
	private static int compteurNumero=1;
	
	public Compte(){
	this.setNumero(compteurNumero); 
	compteurNumero++;
	this.setSolde(0);
	}
	
	public Compte(double solde){
		this.numero = compteurNumero;
		compteurNumero++;
		this.setSolde(solde);
	}

	
	// ajouter un montant dans le compte
	public void ajouter(double montant){
		
		this.setSolde(this.getSolde() + montant );
	}
	
	// retirer un montant du compte
	public void retirer(double montant) throws BanqueException {
		
		this.setSolde(this.getSolde() - montant  );
	}
	
	
	
	public int getNumero() {
		return numero;
	}


	private void setNumero(int numero) {
		this.numero = numero;
	}


	public double getSolde() {
		return solde;
	}


	protected void setSolde(double solde) {
		this.solde = solde;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [numero=");
		builder.append(numero);
		builder.append(", solde=");
		builder.append(solde);
		builder.append("]");
		return builder.toString();
	}
}
