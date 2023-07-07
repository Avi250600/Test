package com.kabir.manu;

public class Join {

	public static int i = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++)
					Join.i++;
				
				for(int j =0 ;j<10;j++)
				{}
			}
		});
		

		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				 try 
				 { 
					 th1.join(); 
				} 
				 catch (InterruptedException e) 
				 { // TODO Auto-generated
				   e.printStackTrace(); 
				  }
				 
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++)
					Join.i++;
			}
		});
		
		th1.start();
		th2.start();
		try {
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The final value of I is :"+i);		
	}
}
