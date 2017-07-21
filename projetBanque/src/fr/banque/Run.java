package fr.banque;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte cpt1=new Compte(1500);
		Compte cpt2=new Compte(2000);
		Compte cpt3=new Compte(3000);
		Compte cpt4=new CompteRemunere(4000);
		CompteRemunere cpt5=new CompteRemunere(5000);
		CompteASeuilRemunere cpt6=new CompteASeuilRemunere(6000);
		
		
		Client cl1=new Client("Boulerouah", "Aoumeur", 37);
		
		try {
			cl1.ajouterCompte(cpt1);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			cl1.ajouterCompte(cpt2);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			cl1.ajouterCompte(cpt3);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			cl1.ajouterCompte(cpt4);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			cl1.ajouterCompte(cpt6);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			cl1.ajouterCompte(cpt5);
		} catch (BanqueException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		System.out.println(cl1);
		
		cpt6.calculerInterets();
		cpt6.verserInterets();
		
		cpt6.setSeuil(5000);
		try {
			cpt6.retirer(500);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cpt5.getTaux());
		
		System.out.println(cl1);
		System.out.println(cl1.getCompte(6));
		
	}

}
