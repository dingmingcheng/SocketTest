package com.test.NIO1;
import java.util.Scanner;
public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		//运行服务器  
        Server.start();  
        //避免客户端先于服务器启动前执行代码  
        Thread.sleep(100);
        String msg = in.nextLine();
        //运行客户端
        Client.start();
        Thread.sleep(10);
        Client.sendMsg(msg);
        while(Client.sendMsg(in.nextLine())); 
	}
}
