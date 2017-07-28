package fr.bandiManchot;

import java.io.Console;

public class MonThread extends Thread {
	
	  private boolean actif = true;
	  static Console cons;
	  
	  
	  // Thread qui s'arrete après l'apui sur entrée
	  
	  public static void main(String[] args) {
	
		 try {

		      MonThread t = new MonThread();

		      t.start();
		      
		      
		      t.arreter();

		    } catch (Exception e) {

		      e.printStackTrace();

		    }

		}

		  public void run() {

		    int i = 0;

		    while (actif) {

		      System.out.println("i = " + i);

		      i++;
		      
		      try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    }

		  }


		  public void arreter() {

		    actif = false;

		  }

		
}


