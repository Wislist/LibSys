package Controller;

import Views.Login;

import javax.swing.*;
import java.awt.event.*;

public class StuLoginHandler extends KeyAdapter implements ActionListener {

   private Login login;


    public StuLoginHandler(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        JRadioButton jRadioButton = (JRadioButton) e.getSource();
        String option = jRadioButton.getText();

        if ("宿管".equals(option)){
            if("登录".equals(text)){
                //登录
                login();
            } else if ("注册".equals(text)) {



            }

        } else if ("学生".equals(text)) {
            if("登录".equals(text)){
                //登录
                login();


            } else if ("注册".equals(text)) {



            }
        }


    }

    private void login() {
        String user = login.getUserTextField().getText();
        String pwd = login.getPassWordTextField().getText();
        System.out.println(user + " " + pwd);
        //查询db
        boolean flag = false;
        if(flag){

        }else {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()){
            login();
        }
    }
}
