package fr.banque;

import java.util.Date;

public class Operation {

	
	private int id;
	private String libelle; 
	private double montant;
	private Date date; 
	private int compteId;
	
	public Operation(){
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCompteId() {
		return compteId;
	}
	public void setCompteId(int compteId) {
		this.compteId = compteId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operation [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", date=");
		builder.append(date);
		builder.append(", compteId=");
		builder.append(compteId);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
