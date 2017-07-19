package fr.banque;

public class CompteRemunere extends Compte {
private static double taux = 0.3 ; // valeur comprise entre 0 et 1



public CompteRemunere() {
	super();
	
}

public CompteRemunere(double solde) {
	super(solde);
	
}

public double calculerInterets() {
	return this.getSolde()*taux;
}

public void verserInterets() {
	
	this.ajouter(this.calculerInterets());
}

public double getTaux() {
	return taux;
}

public void setTaux(double unTaux) {
	taux = unTaux; 
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CompteRemunere [numero=");
	builder.append(this.getNumero());
	builder.append(", solde=");
	builder.append(this.getSolde());
	builder.append("]");
	return builder.toString();
}




}
