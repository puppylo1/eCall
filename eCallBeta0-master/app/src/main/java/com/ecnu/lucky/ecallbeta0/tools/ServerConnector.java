package com.ecnu.lucky.ecallbeta0.tools;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnector
{
    private static final int PORT = 8888;
    private static final String HOST = "192.168.56.1";
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public void startConnect() throws UnknownHostException, IOException
    {
        socket = new Socket(HOST, PORT);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public void closeConnect() throws UnknownHostException, IOException
    {
        oos.close();
        ois.close();
        socket.close();
    }

    public void postObject(Object object) throws UnknownHostException, IOException
    {
        oos.writeObject(object);
        oos.flush();
    }

    public Object getObject() throws UnknownHostException, IOException, ClassNotFoundException
    {
        Object object = ois.readObject();
        return object;
    }

    public void postFileToServer(String filepath) throws UnknownHostException, IOException
    {
        FileInputStream in = new FileInputStream(filepath);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int length = -1;
        // 从文件读取数据至缓冲区
        while ((length = in.read(buffer)) != -1)
        {
            // 将资料写入DataOutputStream中
            out.write(buffer, 0, length);
        }
        out.flush();
        in.close();
        out.close();
    }
}
