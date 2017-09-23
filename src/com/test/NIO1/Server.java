package com.test.NIO1;

public class Server {
	private static int DEFAULT_PORT = 8080;
	private static ServerHandle serverHandle;
	public static void start() {
		start(DEFAULT_PORT);
	}
	
	public static void start(int port) {
		if(serverHandle != null) {
			serverHandle.stop();
		}
		serverHandle = new ServerHandle(port);
        new Thread(serverHandle,"Server").start();
	}
}
