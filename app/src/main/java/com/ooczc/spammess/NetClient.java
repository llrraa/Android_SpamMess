package com.ooczc.spammess;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class NetClient {
    static final String ServerIP = "172.26.49.3";

    public static String isSpamMess(String mess) throws IOException {
        //1.建立客户端socket连接，指定服务器位置及端口

        Socket socket =new Socket(ServerIP,6464);
        System.out.println("111");
        //2.得到socket读写流  
        OutputStream os=socket.getOutputStream();
        PrintWriter pw=new PrintWriter(os);
        System.out.println("222");
        //输入流  
        InputStream is=socket.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        System.out.println("333");
        //3.利用流按照一定的操作，对socket进行读写操作  
//        String info="用户名：Tom,用户密码：123456";  
//        String reply=br.readLine();
//        System.out.println(reply);
        pw.write(mess);
        pw.flush();
        System.out.println("444");
//        socket.shutdownOutput();  
        String reply=br.readLine();
        System.out.println(reply);
        return reply;
        //接收服务器的相应  
//        String reply=null;  
//        while(!((reply=br.readLine())==null)){  
//            System.out.println("接收服务器的信息："+reply);  
//        }  
        
    	/*
    	Socket s=new Socket(ServerIP,6464); 
    	System.out.println("111");
    	
    	DataInputStream in = new DataInputStream(s.getInputStream());
//    	in.read(b);
    	System.out.println("222");
    	String str = new String();
//    	str = in.readUTF();
    	str = in.readLine();
    	System.out.println("333");
    	System.out.println("get: "+str);
    	DataOutputStream out = new DataOutputStream(s.getOutputStream());
    	System.out.println("444");
    	out.write(mess.getBytes());
    	out.flush();
    	str = in.readUTF();
    	System.out.println("555");
    	System.out.println("get: "+str);
    	out.close();
    	in.close();
    	s.close();
    	return str;
    	*/

    }

    /*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = new String("两次价值xxx元王牌项目；可充值xxx元店内项目卡一张；可以参与V动好生活百分百抽奖机会一次！预约电话：xxxxxxxxxxx");
        try{
            System.out.println("start~");
            NetClient.isSpamMess(str);
            System.out.println("over~");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    */

}