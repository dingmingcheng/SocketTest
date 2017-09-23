package com.test.BIO1;
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.net.SocketAddress;
import java.util.concurrent.ThreadPoolExecutor;

public final class ServerNormal {
	//默认的端口号  
    private static int DEFAULT_PORT = 12345;  
    //单例的ServerSocket  
    private static ServerSocket server;
    public static void start() throws IOException {
    	start(DEFAULT_PORT);
    }
  //这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了  
    public static void start(int port) throws IOException{  
        if(server != null) return;  
        try{
            //通过构造函数创建ServerSocket
            //如果端口合法且空闲，服务端就监听成功  
            server = new ServerSocket(port);  
            System.out.println("服务器已启动，端口号：" + port);  
            //通过无限循环监听客户端连接  
            //如果没有客户端接入，将阻塞在accept操作上。  
            while(true){
                Socket socket = server.accept();  
                //当有新的客户端接入时，会执行下面的代码  
                //然后创建一个新的线程处理这条Socket链路  
                new Thread(new ServerHandler(socket)).start();  
            }  
        }finally{  
            //一些必要的清理工作  
            if(server != null){  
                System.out.println("服务器已关闭。");  
                server.close();  
                server = null;  
            }  
        }  
    }  
}
