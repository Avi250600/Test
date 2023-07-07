package com.kabir.manu;

import java.util.Random;

class Test {
	synchronized static public void display(String s) {
		for (int i = 1; i < 11; i++) {
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(125));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i <= 5)
				System.out.print("(");
			else
				System.out.print(")");
		}
		System.out.println();
		System.out.println("This is for :" + s);
	}
}

public class Static_synchronized {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				new Test();
				// TODO Auto-generated method stub
				Test.display("Kabir");
			}
		}).start();
		

		new Thread(new Runnable() {

			@Override
			public void run() {
				new Test();
				// TODO Auto-generated method stub
				Test.display("Manu");
			}
		}).start();
		
		
		

	}
}
