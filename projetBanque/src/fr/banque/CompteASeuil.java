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
	public void retirer(double uneValeur) throws BanqueException {
	
		if( (this.getSolde() - uneValeur) < this.seuil) {
			throw new BanqueException("impossiple d'effectuer l'operation le seuil min est atteint!!! pour:");
		}
		this.setSolde(this.getSolde() - uneValeur);
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





