package Views;

import Pojo.AdminLogin;
import Pojo.StudentLogin;
import Service.AdminService;
import Service.Impl.AdminServiceImpl;
import Service.Impl.StuServiceImpl;
import Service.StuService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterView {
    Login login;
    public RegisterView() {
        JRadioButton teaButton = new JRadioButton("宿管");
        JRadioButton stuButton = new JRadioButton("学生");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(teaButton);
        buttonGroup.add(stuButton);

        JDialog dialog = new JDialog(login,"注册",true);
        dialog.setTitle("填写信息");
        dialog.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 20, 50, 25);
        dialog.add(idLabel);

        JTextField idTextField = new JTextField();
        idTextField.setBounds(80, 20, 150, 25);
        dialog.add(idTextField);

        JLabel pwdLabel = new JLabel("密码:");
        pwdLabel.setBounds(20, 50, 50, 25);
        dialog.add(pwdLabel);

        JPasswordField pwdField = new JPasswordField();
        pwdField.setBounds(80, 50, 150, 25);
        dialog.add(pwdField);

        teaButton.setBounds(80, 110, 80, 25);
        dialog.add(teaButton);

        stuButton.setBounds(170, 110, 80, 25);
        dialog.add(stuButton);

        JButton submitButton = new JButton("提交");
        submitButton.setBounds(80, 140, 80, 25);
        dialog.add(submitButton);

        JLabel nameLabel = new JLabel("姓名:");
        nameLabel.setBounds(20, 80, 50, 25);
        dialog.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(80, 80, 150, 25);
        dialog.add(nameTextField);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                String pwd = new String(pwdField.getPassword());
                String users = nameTextField.getText();
                String userType = teaButton.isSelected() ? "宿管" : "学生"; // 判断用户选择的身份
                // 在这里可以处理用户输入的 ID、密码和身份
                System.out.println(userType);
                if ("宿管".equals(userType)){
                    //调用Service
                    AdminService adminService = new AdminServiceImpl();
                    AdminLogin admin = new AdminLogin();
                    admin.setId(id);
                    admin.setPassword(pwd);
                    admin.setUsers(users);
                    adminService.insert(admin);
                    System.out.println("插入成功");

                } else if ("学生".equals(userType)) {
                    //调用Service
                    StuService stuService = new StuServiceImpl();
                    StudentLogin stu = new StudentLogin();
                    stu.setStuID(id);
                    stu.setName(pwd);
                    stu.setPassword(users);
                    stuService.insert(stu);
                    System.out.println("插入成功");
                }

                dialog.dispose();
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - dialog.getWidth()) / 2;
        int y = (dim.height - dialog.getHeight()) / 2;
        dialog.setBounds(x, y, 250, 300); // 增加了两个单选按钮，高度增加到180
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        dialog.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                dialog.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new RegisterView();
    }
}
