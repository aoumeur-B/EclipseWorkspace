package fr.bandiManchot;

public class PrimeThread extends Thread {
	long minPrime;
	ThreadGroup thgrp;
	String name;
	PrimeThread(ThreadGroup thgrp, String name) {
		super(thgrp,name);
		this.minPrime = 0;
		this.thgrp=thgrp;
		this.name=name;
	}

	public void run() {
		for (int lcI = 0; lcI < 5; lcI++) {
			switch ((int) this.minPrime) {
			case 11:
				System.out.print(this.minPrime+":"+lcI+"|");
				break;
			case 12:
				System.out.print(this.minPrime+":"+lcI+"|");
				break;
			case 13:
				System.out.println(this.minPrime+":"+lcI+"|");
				break;
			default:
				System.out.println("Thread numero superieur à 12: " + this.minPrime + " / " + lcI);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public long getMinPrime() {
		return minPrime;
	}

	public void setMinPrime(long minPrime) {
		this.minPrime = minPrime;
	}

}
