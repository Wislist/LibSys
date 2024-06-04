package Controller;

import Service.UserService;
import Views.Login;

import javax.swing.*;
import java.awt.event.*;

public class LoginHandler  extends KeyAdapter implements ActionListener {

   private Login login;


    public LoginHandler(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if("登录".equals(text)){
            //登录
            login();


        } else if ("重置".equals(text)) {
            login.getUserTextField().setText("");
            login.getPassWordTextField().setText("");
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
