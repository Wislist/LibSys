import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Login extends JFrame {


        JPanel root,centerPanel;
        JLabel userNameLabel,passWordLabel,topWordLabel;
        JTextField userTextField,passWordTextField;
        JButton enterButton,closeButton;
        //弹簧布局
        SpringLayout springLayout;

        StuLoginHandler stuLoginHandler;
    public Login() {

            Container contentPane = getContentPane();

            //loginHandler = new LoginHandler(this);

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
             * TODO:登录操作  注册操作
             */
            Font centerFont = new Font("楷体",Font.PLAIN,20);
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
            //登录按钮ActionListen
            enterButton.addActionListener(stuLoginHandler);




            //注册按钮
            closeButton = new JButton("重置");

            centerPanel.add(closeButton);

            contentPane.add(centerPanel,BorderLayout.CENTER);

            //注册按钮ActionListen
            //closeButton.addActionListener();

            /**
             * TODO: 布局
             */
            layoutCenter();

            /**
             * TODO:设置窗口风格
             */

            //窗体图标
            setTitle("学生宿舍管理");
            URL resource = Login.class.getClassLoader().getResource("Logo.png");
            Image image = new ImageIcon(resource).getImage();
            setIconImage(image);



            setDefaultCloseOperation(EXIT_ON_CLOSE);
            //setBounds(400, 300, 340, 256);
            setLocationRelativeTo(null);
            setSize(600,400);
            setVisible(true);
            //无法调整窗口大小
            setResizable(false);
        }

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
                //button
                springLayout.putConstraint(SpringLayout.WEST,enterButton,50,SpringLayout.WEST,passWordLabel);
                springLayout.putConstraint(SpringLayout.NORTH,enterButton,20,SpringLayout.SOUTH,passWordLabel);
                //button2
                springLayout.putConstraint(SpringLayout.WEST,closeButton,50,SpringLayout.EAST,enterButton);
                springLayout.putConstraint(SpringLayout.NORTH,closeButton,0,SpringLayout.NORTH,enterButton);
        }


        public static void main(String[] args) {
       // new Login().CreateFrame("text");
        new Login();
    }


}
