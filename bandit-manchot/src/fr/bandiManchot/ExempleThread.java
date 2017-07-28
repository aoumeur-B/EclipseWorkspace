package fr.bandiManchot;

public class ExempleThread implements Runnable {

	private String nom;
	
	public ExempleThread(String unNom) {
		super();
		this.nom = unNom;
	}


	@Override
	public void run() {
	for (int lcI = 0; lcI < 5; lcI++) {
	System.out.println(this.nom + " " + lcI);
	}
	}
	

}
