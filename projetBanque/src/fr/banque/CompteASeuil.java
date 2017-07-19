package fr.banque;

public class CompteASeuil extends Compte {
	
	private double seuil;

	// constructeur par defaut
	public CompteASeuil() {
		super();
		
	}
	
	public CompteASeuil(double solde) {
		super(solde);
		
	}
	
	// methode pour vérifier le respect du seuil au retrait d'une somme
	public void retirer(double uneValeur) {
	
		if( (this.getSolde() - uneValeur) >= this.seuil) {
			this.setSolde(this.getSolde() - uneValeur);
		}else {
				System.out.println("impossiple d'effectuer l'operation le seuil min est atteint!!! pour: ");
				}
	}

	
	
	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteASeuil [numero=");
		builder.append(this.getNumero());
		builder.append(", solde=");
		builder.append(this.getSolde());
		builder.append("]");
		return builder.toString();
	}

	
}





