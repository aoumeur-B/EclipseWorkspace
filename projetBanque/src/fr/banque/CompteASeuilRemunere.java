package fr.banque;

public class CompteASeuilRemunere extends CompteASeuil implements ICompteRemunere{
	
	private static double taux = 0.3 ; // valeur comprise entre 0 et 1

	
	public CompteASeuilRemunere(){
		super();
	}
	
	public CompteASeuilRemunere(double solde) {
		super(solde);
	}

	@Override
	public double calculerInterets() {
		return this.getSolde()*taux;
	}

	@Override
	public void verserInterets() {
		this.ajouter(this.calculerInterets());
	}

	@Override
	public double getTaux() {
		return taux;
	}

	@Override
	public void setTaux(double unTaux) {
		taux = unTaux; 
	}
}
