package Views;

import Pojo.AdminLogin;
import Pojo.Student;
import Pojo.StudentLogin;
import Service.AdminService;
import Service.Impl.AdminServiceImpl;
import Service.Impl.StuServiceImpl;
import Service.StuService;
import Views.StudentInterface.Main_view;
import Views.StudentInterface.StuMainInterface.StuMainInterface;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class LoginView extends JFrame {


        JPanel centerPanel;
        JLabel userNameLabel,passWordLabel,topWordLabel,optionWordLabel;
        @Getter@Setter
        JTextField userTextField,passWordTextField;
        JButton enterButton,closeButton;

        JRadioButton stuButton,teaButton;

        ButtonGroup buttonGroup;

        SpringLayout springLayout;




    public LoginView() {

            Container contentPane = getContentPane();

            springLayout = new SpringLayout();
            centerPanel = new JPanel(springLayout);
            /**
             * 标题
             */
            topWordLabel = new JLabel("学生宿舍管理系统",JLabel.CENTER); // TopLabel
            topWordLabel.setFont(new Font("华文行楷", Font.PLAIN, 40));
            topWordLabel.setPreferredSize(new Dimension(0,80));
            contentPane.add(topWordLabel,BorderLayout.NORTH);


            /**
             * TODO:将东西填上去
             */
            Font centerFont = new Font("楷体",Font.PLAIN,20);


            //选项标签
            optionWordLabel = new JLabel("用 户:");
            optionWordLabel.setFont(centerFont);
            centerPanel.add(optionWordLabel);

            //选项
            teaButton = new JRadioButton("宿管");
            stuButton = new JRadioButton("学生");
            buttonGroup = new ButtonGroup();
            buttonGroup.add(teaButton);
            buttonGroup.add(stuButton);

            centerPanel.add(teaButton);
            centerPanel.add(stuButton);


            //用户名标签
            userNameLabel = new JLabel("用户名：");
            userNameLabel.setFont(centerFont);
            centerPanel.add(userNameLabel);

            //用户名文本框
            userTextField = new JTextField(12);
            userTextField.setPreferredSize(new Dimension(200,30));
            centerPanel.add(userTextField);

            //密码标签
            passWordLabel = new JLabel("密 码：");       //定义标签对象
            passWordLabel.setFont(centerFont);
            centerPanel.add(passWordLabel);

            //密码文本框
            passWordTextField = new JTextField(12);
            passWordTextField.setPreferredSize(new Dimension(200,30));
            centerPanel.add(passWordTextField);

            //登录按钮
            enterButton = new JButton("登录");          //定义按钮对象

            centerPanel.add(enterButton);




            //注册按钮
            closeButton = new JButton("注册");

            centerPanel.add(closeButton);


            contentPane.add(centerPanel,BorderLayout.CENTER);


            //TODO:布局设置
            layoutCenter();
            //TODO:button
            ButtonAction();

            /**
             * TODO:设置窗口风格
             */

            //窗体图标
            setTitle("学生宿舍管理");
            URL resource = LoginView.class.getClassLoader().getResource("Logo.png");
            Image image = new ImageIcon(resource).getImage();
            setIconImage(image);

            //设置lginenter为默认按钮
            getRootPane().setDefaultButton(enterButton);



            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setSize(600,400);
            setVisible(true);
            //无法调整窗口大小
            setResizable(false);
        }

        /**
         * TODO:布局设置
         */
        private void layoutCenter() {
                Spring childWidth = Spring.sum(Spring.sum(Spring.width(userNameLabel),Spring.width(userTextField)),
                        Spring.constant(20));
                int offsetX = childWidth.getValue() / 2;
                springLayout.putConstraint(SpringLayout.WEST,userNameLabel,-offsetX,
                        SpringLayout.HORIZONTAL_CENTER,centerPanel);
                springLayout.putConstraint(SpringLayout.NORTH,userNameLabel,20,
                        SpringLayout.NORTH,centerPanel);
                //userTextField
                springLayout.putConstraint(SpringLayout.WEST,userTextField,20,
                        SpringLayout.EAST,userNameLabel);
                springLayout.putConstraint(SpringLayout.NORTH,userTextField,0,
                        SpringLayout.NORTH,userNameLabel);
                //密码
                springLayout.putConstraint(SpringLayout.EAST,passWordLabel,0,
                        SpringLayout.EAST,userNameLabel);
                springLayout.putConstraint(SpringLayout.NORTH,passWordLabel,20,
                        SpringLayout.SOUTH,userNameLabel);
                //框
                springLayout.putConstraint(SpringLayout.WEST,passWordTextField,20,
                        SpringLayout.EAST,passWordLabel);
                springLayout.putConstraint(SpringLayout.NORTH,passWordTextField,0,
                        SpringLayout.NORTH,passWordLabel);
                //选项label
                springLayout.putConstraint(SpringLayout.EAST,optionWordLabel,0,
                        SpringLayout.EAST,passWordLabel);
                springLayout.putConstraint(SpringLayout.NORTH,optionWordLabel,20,
                        SpringLayout.SOUTH,passWordLabel);
                //jbutton
                springLayout.putConstraint(SpringLayout.WEST,teaButton,30,SpringLayout.EAST,optionWordLabel);
                springLayout.putConstraint(SpringLayout.NORTH,teaButton,0,SpringLayout.NORTH,optionWordLabel);

                springLayout.putConstraint(SpringLayout.WEST,stuButton,20,SpringLayout.EAST,teaButton);
                springLayout.putConstraint(SpringLayout.NORTH,stuButton,0,SpringLayout.NORTH,teaButton);

                //button
                springLayout.putConstraint(SpringLayout.WEST,enterButton,50,SpringLayout.WEST,passWordLabel);
                springLayout.putConstraint(SpringLayout.NORTH,enterButton,50,SpringLayout.SOUTH,passWordLabel);
                //button2
                springLayout.putConstraint(SpringLayout.WEST,closeButton,50,SpringLayout.EAST,enterButton);
                springLayout.putConstraint(SpringLayout.NORTH,closeButton,0,SpringLayout.NORTH,enterButton);
        }

        /**
         * 按钮功能实现
         * @param
         */
        private String text,option;

        public void ButtonAction(){

                enterButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                JButton jButton = (JButton) e.getSource();
                                text = jButton.getText();
                                Login();
                                System.out.println(text);
                        }


                });
                closeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                JButton jButton = (JButton) e.getSource();
                                String text = jButton.getText();
                                //到RegisterView
                                new RegisterView();
                                System.out.println(text);
                        }
                });

                teaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                JRadioButton jRadioButton = (JRadioButton) e.getSource();
                                option = jRadioButton.getText();
                                if(option == null) {
                                        JOptionPane.showMessageDialog(null,"未选择用户","错误",JOptionPane.ERROR_MESSAGE);
                                }
                                System.out.println(option);
                        }
                });

                stuButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                JRadioButton jRadioButton = (JRadioButton) e.getSource();
                                option = jRadioButton.getText();
                                System.out.println(option);
                        }
                });




        }





        private void Login() {
                String id = getUserTextField().getText();
                String pwd = getPassWordTextField().getText();
                System.out.println(id + " " + pwd);
                //校验
                if (id == null || "".equals(id) ||
                        pwd == null || "".equals(pwd.trim())){
                        JOptionPane.showMessageDialog(null,"用户id和密码必填","错误",JOptionPane.ERROR_MESSAGE);
                }

                //查询db
                if ("宿管".equals(option)){
                        AdminService adminService = new AdminServiceImpl();
                        AdminLogin admin = new AdminLogin();
                        admin.setId(id);
                        admin.setPassword(pwd);
                        boolean flag = adminService.findById(admin);
                        if(flag){
                                //跳转到宿管主页

                                dispose();
                        }else {
                                JOptionPane.showMessageDialog(null,"宿管用户名密码错误！");
                        }
                } else if ("学生".equals(option)) {
                        StuService stuService = new StuServiceImpl();
                        StudentLogin students = new StudentLogin();
                        students.setStuID(id);
                        students.setPassword(pwd);

                        boolean flag = stuService.findById(students);
                        if(flag){
                                //跳转到学生主页

                                SwingUtilities.invokeLater(() -> new Main_view());
                                dispose();
                        }else {
                                JOptionPane.showMessageDialog(null,"学生用户名密码错误！");
                        }
                }


        }

}
