package com.kabir.manu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class myThread extends Thread
{
	private String s;
	private CountDownLatch latch;

	

	public CountDownLatch getLatch() {
		return latch;
	}

	public myThread(String s, CountDownLatch latch) {
		this.s = s;
		this.latch = latch;
	}

	public String getS() {
		return s;
	}

	@Override
	public String toString() {
		return "myThread [s=" + s +"]";
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(toString());
		latch.countDown();
	}
}

public class Thread_pool {
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CountDownLatch latch = new CountDownLatch(11);
		myThread th1 = new myThread("Kabir",latch);
		myThread th2 = new myThread("Paglu",latch);
		myThread th3 = new myThread("Manu",latch);
		myThread th4 = new myThread("Avi",latch);
		myThread th5 = new myThread("Bunny",latch);
		myThread th6 = new myThread("Cuttuu",latch);
		myThread th7 = new myThread("Bandarr",latch);
		myThread th8 = new myThread("Gadhi",latch);
		myThread th9 = new myThread("Baagad Billa",latch);
		myThread th10 = new myThread("baby ",latch);
		myThread th11 = new myThread("daddy",latch);
		
		executorService.execute(th1);
		executorService.execute(th2);
		executorService.execute(th3);
		executorService.execute(th4);
		executorService.execute(th5);
		executorService.execute(th6);
		executorService.execute(th7);
		executorService.execute(th8);
		executorService.execute(th9);
		executorService.execute(th10);
		executorService.execute(th11);
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main");
		
		
	}
	
	
	
}
