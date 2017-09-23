package com.test.BIO1;

import java.io.IOException;
import java.util.*;
/*
 * 
 */
public class Test1 {
	/*
	 * 
	 * */
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					ServerNormal.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
		char operators[] = {'+','-','*','/'};
		Thread.sleep(100);
        Random random = new Random(System.currentTimeMillis());
        new Thread(new Runnable(){

			@SuppressWarnings("static-access")
			@Override
			public void run() {				
				String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1); 
				Client.send(expression);									
			}
        	
        }).start();
        new Thread(new Runnable(){

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1); 
				Client.send(expression);					
			}
        	
        }).start();
        new Thread(new Runnable(){

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1); 
				Client.send(expression);					
			}
        	
        }).start();
        new Thread(new Runnable(){

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1); 
				Client.send(expression);					
			}
        	
        }).start();
	}
}
