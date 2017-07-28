package fr.bandiManchot;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		/*
		 * Scanner scr=new Scanner(System.in);
		 * System.out.println("Saisissez a pour commencer"); String str=scr.nextLine();
		 * if(str.equals("a")) { for(int i=0; i<10;i++) { System.out.println(i); } }
		 * scr.close();
		 */
	
		
			ThreadGroup tg = new ThreadGroup("Mon groupe");
			Thread t1 = new Thread(tg, new ExempleThread("Trt 1 "));
			Thread t2 = new Thread(tg, new ExempleThread("Trt 2 "));
			Thread t3 = new Thread(tg, new ExempleThread("Trt 3 "));
			
			t1.start();
			t2.start();
			t3.start();
			
			
			System.out.println(	t1.getThreadGroup().toString());
			System.out.println(t2.getThreadGroup().toString());
			System.out.println(t3.getThreadGroup().toString());
		/*
		ThreadGroup thgrp = new ThreadGroup("Mon groupe");
		PrimeThread p = new PrimeThread(thgrp,"roue");
		p.setMinPrime(p.getId());
		PrimeThread p1 = new PrimeThread(thgrp,"roue");
		p1.setMinPrime(p1.getId());
		PrimeThread p2 = new PrimeThread(thgrp,"roue");
		p2.setMinPrime(p2.getId());
		
		
		p1.setPriority(6);
		p2.setPriority(7);
		
		p.start();
		p1.start();
		p2.start();
		
		System.out.println(	p.getPriority());
		System.out.println(p1.getPriority());
		System.out.println(p2.getPriority());
		
*/
	}

}
