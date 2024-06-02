package 参考代码;

import javax.swing.*;

public class Create_GUI {


    public static void Create_GUI(){
        JFrame frame=new MyQQ_Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Create_GUI::Create_GUI); //lambada  关闭窗口同时也结束程序
    }
}
