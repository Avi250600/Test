package com.kabir.manu;

import java.util.Random;

class Demo extends Thread
{
	private int i;

	public int getI() {
		return i;
	}

	public Demo(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		display();
	}
	
	public void display()
	{
		try {
			sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 1;j<11;j++) 
		{
			System.out.println("Hello number:"+i+" , this is round:"+j);
		}
	}
	
}

class Demo2 implements Runnable
{
	private int i;

	public int getI() {
		return i;
	}

	public Demo2(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		display();
	}
	
	synchronized public void display()
	{
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(1256));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 1;j<11;j++) 
		{
			System.out.println("Hello number:"+i+" , this is round:"+j);
		}
	}
	
}

public class basic {
	
	public static void main(String[] args) throws InterruptedException {
		Demo D1 = new Demo(1);
		Demo D2 = new Demo(2);
		
		long StartTime = System.currentTimeMillis();
		D1.start();
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		D2.start();
		Thread.sleep(4000);
		long EndTime = System.currentTimeMillis();
		System.out.println("Total time:"+(EndTime-StartTime));
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		Demo2 D3 = new Demo2(3);
		Thread t1 = new Thread(D3);
		Thread t2 = new Thread(new Demo2(4));
		t1.start();
		t2.start();
		Thread.sleep(4000);
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<15;i++) 
				{
					try {
						Thread.sleep(750);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hello");
				
			}
		}).start();
	}

}
