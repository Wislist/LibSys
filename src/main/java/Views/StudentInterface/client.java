package Views.StudentInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class client extends JFrame{
    private JFrame frame;
    private JPanel panel1,panel2,panel3;
    private  JTextArea Chat_box,input_box;

    private JButton connect_button,send_button;
    //设置成全局变量，方便调用
    private Socket socket;

    public static void main(String[] args) {
        client client=new client();

    }
    public client(){
        //GUI界面
        frame=new JFrame("学生端");
        frame.setBounds(900,100,360,360);
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        Chat_box=new JTextArea(13,30);
        JScrollPane jScrollPane=new JScrollPane(Chat_box);
        panel1.add(jScrollPane, BorderLayout.NORTH);
        input_box=new JTextArea(4,30);
        connect_button=new JButton("连接");
        send_button=new JButton("发送");
        panel2.add(input_box, BorderLayout.CENTER);
        panel3.add(connect_button,BorderLayout.WEST);
        panel3.add(send_button,BorderLayout.SOUTH);
        frame.getContentPane().add(panel1,BorderLayout.NORTH);
        frame.getContentPane().add(panel2,BorderLayout.CENTER);
        frame.getContentPane().add(panel3,BorderLayout.SOUTH);
        Chat_box.setText("宿管工作时间：\n             10：00-12：30\n             14：30-21：00\n点击“连接”按钮连接宿管\n");

        Chat_box.setEditable(false);//对话框不可编辑
        //自动换行
        Chat_box.setLineWrap(true);
        Chat_box.setWrapStyleWord(true);
        input_box.requestFocus();//对话框聚焦

        frame.setVisible(true);
        init();
    }
    void init(){
        //点击send发送文本框内容
        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=input_box.getText().toString();
                if (str.trim().length()==0)//判断发送是否为空
                    return;
                send(str);
                Chat_box.append("学生端(我)"
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
                    Chat_box.append("学生端(我)"
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
                    socket=new Socket("localhost",8888);
                    Chat_box.append("宿管端连接成功 \n\n");
                    new Thread(new Receive()).start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    void send(String str){
        try {

            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            dataOutputStream
                    .writeUTF("学生端"
                            +new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime())
                            +":\n"+str+" "+"\n");
            if(str.contains("bye"))//不能用 equals()
                System.exit(0);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    class Receive implements Runnable{
        @Override
        public void run() {
            try {
                DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
                String str;
                while (true){
                    str=dataInputStream.readUTF();
                    Chat_box.append(str+"\n");
                    Chat_box.setCaretPosition(Chat_box.getText().length());//滚动条到底
                    //输入bye退出
                    if(str.contains("bye"))//不能用 equals()
                        System.exit(0);
                }
            }catch (SocketException ex){
                Chat_box.append("服务器连接错误\n");
            } catch(IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
