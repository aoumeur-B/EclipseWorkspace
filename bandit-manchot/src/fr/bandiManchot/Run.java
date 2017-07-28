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
		/*
		 * ExempleThread mythred= new ExempleThread("Trt 1 ");
		 * 
		 * ThreadGroup tg = new ThreadGroup("Mon groupe"); Thread roue1 = new Thread(tg,
		 * );
		 * 
		 * 
		 * 
		 * Thread roue2 = new Thread(tg, new ExempleThread("Trt 2 ")); Thread roue3 =
		 * new Thread(tg, new ExempleThread("Trt 3 ")); roue2.start(); roue3.start();
		 * roue1.start();
		 */
		ThreadGroup thgrp = new ThreadGroup("Mon groupe");
		PrimeThread p = new PrimeThread(thgrp,"roue");
		p.setMinPrime(p.getId());
		PrimeThread p1 = new PrimeThread(thgrp,"roue");
		p1.setMinPrime(p1.getId());
		PrimeThread p2 = new PrimeThread(thgrp,"roue");
		p2.setMinPrime(p2.getId());

		p.start();
		p1.start();
		p2.start();

	}

}
