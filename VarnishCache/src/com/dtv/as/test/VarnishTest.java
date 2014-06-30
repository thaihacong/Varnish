package com.dtv.as.test;

public class VarnishTest extends Thread {
	private int numRequest = 10;
	private int numThread = 10;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		long startTime = System.currentTimeMillis();

		VarnishTest varnishTest = new VarnishTest();
		varnishTest.start();
		varnishTest.join();
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Done");
		System.out.println("Total time: " + (double) totalTime/1000 + "s");
	}
	
	public void run() {
		this.investigate(numRequest, numThread);
	}
	
	public void investigate(int numRequest, int numThread) {
		CalculatorThread[] threads = new CalculatorThread[numThread];
		for (int i = 0; i < numThread; i++) {
			threads[i] = new CalculatorThread(numRequest);
			threads[i].start();
			System.out.println(threads[i].getName());
		}
		
		for (int i = 0; i < numThread; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
