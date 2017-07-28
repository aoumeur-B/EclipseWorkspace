package fr.bandiManchot;



public class Roue implements Runnable {

	private int result;
	private int[] roue= {0,1,2,3,4,5,6,7,8,9};
	private boolean condition=true;
	
	public Roue() {
		
	}
	
	public void startRoue() {
		int i = this.result;
		 do{
			
			System.out.println(roue[i]);
			i++;
			 if (i==10) {
				 i=0;
			 }
			
		}while(condition);
	}
	
	public void stopRoue() {
		
	}
	
	public int getResult() {
		int valeur=0;
		
		return valeur;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
