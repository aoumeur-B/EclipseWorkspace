package fr.bandiManchot;

public class ExempleThread implements Runnable {

	private String nom;
	private long numero;
	public ExempleThread(String unNom) {
	super();
	this.nom = unNom;
	}
	
	public ExempleThread(long id) {
		// TODO Auto-generated constructor stub
		this.numero= id;
	}

	@Override
	public void run() {
	for (int lcI = 0; lcI < 5; lcI++) {
	System.out.println(this.numero + " " + lcI);
	}
	}
	

}
