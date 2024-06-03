package Controller;

import Pojo.Users;
import Service.UserService;
import Views.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginHandler extends KeyAdapter implements ActionListener {

   private Login login;

   //引入Service层


    private Users user;

    public LoginHandler(Login login) {
        this.login =login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if ("登录".equals(text)){
            login();
        } else if ("注册".equals(text)) {

        }


    }

    private void login() {
        //获取到内容
        String name = login.getUserTextField().getText();
        String password = login.getPassWordTextField().getText();
//            System.out.println(name+" "+password);
        /**
         * 查询数据库
         */
        boolean flag = false;
        if (flag){

        }else {
            JOptionPane.showConfirmDialog(login,"用户名或者密码错误！");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()){
            login();
        }

    }
}
