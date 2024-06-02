import javax.swing.*;

public class JTextFieldFrame extends JFrame {
    JPanel root;
    JLabel userNameLabel,passWordLabel;
    JTextField userTextField,passWordTextField;
    JButton enterButton,closeButton;

    public JTextFieldFrame() {
        root = new JPanel();      //定义面板容器
        setContentPane(root);
        setLayout(null);         //设置面板为绝对布局

        //用户名标签
        userNameLabel = new JLabel("用户名：");
        userNameLabel.setBounds(52, 33, 54, 15);
        root.add(userNameLabel);

        //用户名文本框
        userTextField = new JTextField(12);
        userTextField.setBounds(116, 30, 139, 21);
        root.add(userTextField);

        //密码标签
        passWordLabel = new JLabel("密 码：");       //定义标签对象
        passWordLabel.setBounds(52, 74, 54, 15);
        root.add(passWordLabel);

        //密码文本框
        passWordTextField = new JTextField(12);
        passWordTextField.setBounds(116, 71, 139, 21);
        root.add(passWordTextField);

        //登录按钮
        enterButton = new JButton("登录");          //定义按钮对象
        enterButton.setBounds(64, 116, 69, 23);
        root.add(enterButton);

        //退出按钮
        closeButton = new JButton("退出");
        closeButton.setBounds(174, 116, 69, 23);
        root.add(closeButton);

        //设置窗口风格
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400, 300, 340, 256);
        setVisible(true);
    }

    //main方法
    public static void main(String[] args) {
        new JTextFieldFrame();
    }

}
