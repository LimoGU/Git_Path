import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {
	public static  void main(String args[]){
		
		try {
			int k=0;
			ServerSocket serverSocket=new ServerSocket(8888);
			System.out.println("服务器启动........");
		
		while(true){
			System.out.println("等待接收........");
			Socket socket=serverSocket.accept();
			k++;			
			OutputStream out=socket.getOutputStream();
			String msg="Hello Android!";
			out.write(msg.getBytes());
			out.close();
			System.out.println("当前服务器连接的数量："+k);

			
			
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
