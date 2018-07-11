package org.zemo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @ClassName: IOService
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 21/08/2017 15:57
 * @Description ${TODO}
 */
public class IOService {

    public static void server(){
        ServerSocket serverSocket = null;
        InputStream in = null;

        try {
            serverSocket = new ServerSocket(8765);
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];
            while (true) {
                Socket clientSocket = serverSocket.accept();
                SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
                System.out.println("Handling client at " + clientAddress);
                in = clientSocket.getInputStream();
                while ((recvMsgSize = in.read(recvBuf)) != -1) {
                    byte[] tmp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, tmp, 0, recvMsgSize);
                    System.out.println(new String(tmp));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        server();
    }
}
