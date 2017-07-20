package model;

public class Ordinateur {
	private int ordinateurId;
	private String fabricant;
	private String model;
	private String tailleDD;
	private String tailleMemoire;
	private String tailleEcran;
	private String typeProcesseur;
	
	
	public int getOrdinateurId() {
		return ordinateurId;
	}
	public void setOrdinateurId(int ordinateurId) {
		this.ordinateurId = ordinateurId;
	}
	
	public String getFabricant() {
		return fabricant;
	}
	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTailleDD() {
		return tailleDD;
	}
	public void setTailleDD(String tailleDD) {
		this.tailleDD = tailleDD;
	}
	
	public String getTailleMemoire() {
		return tailleMemoire;
	}
	public void setTailleMemoire(String tailleMemoire) {
		this.tailleMemoire = tailleMemoire;
	}
	
	
	public String getTailleEcran() {
		return tailleEcran;
	}
	public void setTailleEcran(String tailleEcran) {
		this.tailleEcran = tailleEcran;
	}
	public String getTypeProcesseur() {
		return typeProcesseur;
	}
	public void setTypeProcesseur(String typeProcesseur) {
		this.typeProcesseur = typeProcesseur;
	}
	
	@Override
	public String toString() {
		return "Ordinateur [ordinateurId=" + ordinateurId + ", fabricant=" + fabricant + ", model=" + model
				+ ", tailleDD=" + tailleDD + ", tailleMemoire=" + tailleMemoire + ", tailleEcran=" + tailleEcran
				+ ", typeProcesseur=" + typeProcesseur + "]";
	}
	
	
	
	
	
	
	

}
