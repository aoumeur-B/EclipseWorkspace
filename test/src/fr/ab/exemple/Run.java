package fr.ab.exemple;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Voiture v =new Voiture();
		System.out.println("voiture dans fct1 : "+v);
		add(v);
	}
	public static void add(Voiture b) {
		System.out.println("voiture dans fct1 : "+ b);
	}

}
