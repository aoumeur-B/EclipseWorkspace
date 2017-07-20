package fr.ab.exemple;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Run {
	
	

	public static void main(String[] args) {
		
		List<Voiture> list = new ArrayList<Voiture>();
		

		
		
		Iterator<Voiture> iterator= list.iterator();
		 while(iterator.hasNext()){
			 Voiture voiture= iterator.next();
			 System.out.println(voiture);
			 
		 }
		
		
	}
	

}
