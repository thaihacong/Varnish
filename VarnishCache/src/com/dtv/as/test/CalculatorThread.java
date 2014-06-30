package com.dtv.as.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class CalculatorThread extends Thread {
	private int numThread;
	private String url1 = "http://localhost:8081/VarnishCache/do?a=1&b=2";
	private String url2 = "http://www.varnishtest.com/do?a=1&b=2";
	
	public CalculatorThread(int numThread) {
		this.numThread = numThread;
	}
	
	public void run() {
		for(int i = 0; i < numThread; i++) {
			try {
				this.performGet();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void performGet() throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		HttpGet httpGet = new HttpGet(url1);
		
		HttpResponse response = httpClient.execute(httpGet);
		
		// System.out.println(response.getStatusLine().getStatusCode());
	}
}
