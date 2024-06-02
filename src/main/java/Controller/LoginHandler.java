package Controller;

import Service.UserService;
import Views.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {

   private Login loginView;

   //引入Service层
    private UserService userService;

    public LoginHandler(Login login) {
        this.loginView =login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
