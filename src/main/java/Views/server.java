package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class server extends JFrame{

    private JFrame frame;
    private JPanel panel1,panel2,panel3;
    private  JTextArea Chat_box,input_box;

    private JButton connect_button,send_button;
    //设置成全局变量，方便调用
    private ServerSocket serverSocket= null;
    //多个客户端
    private List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        server server=new server();
        server.init();
    }
    public server() throws HeadlessException{
        super();
        //GUI界面
        frame=new JFrame("server");
        frame.setBounds(500,100,360,360);
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        Chat_box=new JTextArea(13,30);
        JScrollPane jScrollPane=new JScrollPane(Chat_box);
        panel1.add(jScrollPane,BorderLayout.NORTH);
        input_box=new JTextArea(4,30);
        connect_button=new JButton("connect");
        send_button=new JButton("send");
        panel2.add(input_box, BorderLayout.CENTER);
        panel3.add(connect_button,BorderLayout.WEST);
        panel3.add(send_button,BorderLayout.SOUTH);
        frame.getContentPane().add(panel1,BorderLayout.NORTH);
        frame.getContentPane().add(panel2,BorderLayout.CENTER);
        frame.getContentPane().add(panel3,BorderLayout.SOUTH);

        Chat_box.setEditable(false);//对话框不可编辑
        //自动换行
        Chat_box.setLineWrap(true);
        Chat_box.setWrapStyleWord(true);
        input_box.requestFocus();//对话框聚焦
        //关闭窗口即退出程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void init(){
        //点击send发送文本框内容
        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=input_box.getText().toString();
                if (str.trim().length()==0)
                    return;

                send(str);
                Chat_box.append("服务器(我)"
                        +new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime())
                        +":\n"+str+" "+"\n\n");
                input_box.setText("");//清空对话框
            }
        });
        //回车发送文本框内容
        input_box.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    String str=input_box.getText().toString();
                    if (str.trim().length()==0)
                        return;
                    send(str);
                    Chat_box.append("服务器(我)"
                            +new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime())
                            +":\n"+str+" "+"\n\n");
                    input_box.setText("");//清空对话框
                }
                input_box.setText("");
            }
        });
        connect_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serverSocket = new ServerSocket(8888);
                    Chat_box.append("服务器已启动，等待连接中... \n");

                    new Thread(new StartUp()).start();

                } catch (IOException ex) {
                   ex.printStackTrace();
                }

            }
        });
    }

    void send(String str){
        //发送给每个已连接客户端
        for (Socket socket: clients){
            try {
                //建立向客户端的输出流
                DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
                dataOutputStream
                        .writeUTF("服务器"
                                +new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime())
                                +":\n"+str+" "+"\n");
                //输入bye退出
                if(str.contains("bye"))//不能用 equals()
                    System.exit(0);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    class StartUp implements Runnable{

        @Override
        public void run() {
            try {
                while (true){
                    Socket socket=serverSocket.accept();
                    clients.add(socket);
                    new Thread(new Receive(socket)).start();
                    Chat_box.append("客户端连接成功 \n\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    class Receive implements Runnable{
        private Socket client;
        Receive(Socket client){
            this.client=client;
        }
        @Override
        public void run() {
            try {
                //建立向客户端的输入流
                DataInputStream dataInputStream=new DataInputStream(client.getInputStream());
                String str;
                while (true){
                    str=dataInputStream.readUTF();
                    Chat_box.append(str+"\n");
                    Chat_box.setCaretPosition(Chat_box.getText().length());//滚动条到底


                }
            }catch (SocketException e){
                Chat_box.append("客户端断开\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                clients.remove(client);
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
