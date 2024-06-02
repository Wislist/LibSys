package 参考代码;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyQQ_Frame extends JFrame{
    int x,y;

    //承接用户名图标
    JLabel users=new JLabel();
    //承接密码图标
    JLabel codes=new JLabel();
    //承接关闭图标
    JButton close=new JButton();
    //承接背景图片
    JLabel bg=new JLabel();
    //承接头像图片
    JLabel tx=new JLabel();
    //写文字QQ
    JLabel qq=new Create_label("2020",Color.white);
    //用户名输入框
    JTextField userfield=new Create_textfield(10);
    //密码输入框
    JPasswordField codefield=new Create_codefield(10);
    //登录按钮
    JButton button=new Create_Login_Button("登录");
    //资源文件路径
//    URL url0=getClass().getResource("/img/users.png");
//    URL url1=getClass().getResource("/img/code.png");
//    URL url2=getClass().getResource("/img/close.png");
//    URL url3=getClass().getResource("/img/bg.JPG");
//    URL url4=getClass().getResource("/img/qq0.png");
//    //声明图标
//    Icon users_icon=new ImageIcon(url0);
//    Icon codes_icon=new ImageIcon(url1);
//    Icon close_icon=new ImageIcon(url2);
//    Icon bg_icon=new ImageIcon(url3);
//    Icon touxiang=new ImageIcon(url4);
    int left,top;
    //构造方法
    public MyQQ_Frame() {

        //设置窗体大小
        setSize(425,330);
        //去除标题栏
        setUndecorated(true);
        //设置可见性
        setVisible(true);



        // 设置窗体透明度





        //由于没有标题栏所以界面不能拖动改变位置
        //采取以下方法可以解决
        //静态鼠标触发器
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
//				System.out.println("鼠标按下");
                //当鼠标点击时获取距离屏幕的坐标
                x=e.getX();
                y=e.getY();
            }
        });
        //动态鼠标触发器
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e){
//				System.out.println("鼠标拖动");
                //获取当前位置的横坐标和纵坐标 left and top

                //横向移动距离=横向动态坐标-鼠标点击时的横向静态坐标
                //纵向移动距离=纵向动态坐标-鼠标点击时的纵向静态坐标
                //设置可变化的位置 加上原来的位置即可
                left=getLocation().x;
                top=getLocation().y;
                setLocation(left+e.getX()-x, top+e.getY()-y);
            }
        });
        //创建容器JPanel
        JPanel jPanel=new JPanel();
        //取代顶层容器
        this.setContentPane(jPanel);
        //添加图标
//        users.setIcon(users_icon);
//        codes.setIcon(codes_icon);
//        close.setIcon(close_icon);
//        bg.setIcon(bg_icon);
//        close.setIcon(close_icon);
//        tx.setIcon(touxiang);
        //设置背景
       // jPanel.setBackground(Color.white);
       // jPanel.setOpaque(true);
        //设置布局
        jPanel.setLayout(new SimpleLayout());
        //添加文本框
        MatteBorder matteBorder=new MatteBorder(0, 0, 1, 0, Color.gray);
        userfield.setBorder(matteBorder);
        jPanel.add(userfield);
        //添加用户图标
        jPanel.add(users);
        //添加密码
        codefield.setBorder(matteBorder);
        jPanel.add(codefield);
        Border border=BorderFactory.createEmptyBorder(1, 1, 1, 1);
        close.setFocusPainted(false);
        close.setPreferredSize(new Dimension(50, 30));
        close.setBackground(new Color(0,131,255));
        close.setBorder(border);
        close.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                close.setBackground(Color.red);
            }
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根
                close.setBackground(new Color(0,131,255));
            }
        });
        close.addActionListener((e)->{
            this.dispose();
        });
        jPanel.add(close);
        jPanel.add(codes);
        jPanel.add(tx);
        jPanel.add(qq);
        jPanel.add(bg);
        jPanel.add(button);
        button.addActionListener((e)->{
            String names=userfield.getText();
            @SuppressWarnings("deprecation")
            String mima=codefield.getText();
            users[]yonghu=new users[5];
            for(int q=0;q<5;q++){
                yonghu[q]=new users();
            }
            yonghu[0].users="3320938770";
            yonghu[1].users="1321824584";
            yonghu[2].users="2939634393";
            yonghu[3].users="1812352723";
            yonghu[4].users="1369286377";
            int count=0;
            for(int i=0;i<5;i++){
                if(yonghu[i].users.equals(names)&&mima.equals("123")){
                    count++;
                }
            }
            if(count==1){
                JOptionPane.showConfirmDialog(jPanel, "登录成功", "提示", JOptionPane.DEFAULT_OPTION);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"没有注册","登录失败",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    private class Create_textfield extends JTextField{
        public Create_textfield(int n) {
            super(n);
            setFont(new Font("宋体", 1, 15));
            setPreferredSize(new Dimension(215, 30));
        }
    }
    private class Create_codefield extends JPasswordField{
        public Create_codefield(int n) {
            super(n);
            setFont(new Font("宋体", 1, 15));
            setPreferredSize(new Dimension(215, 30));
        }
    }
    private class Create_label extends JLabel{
        public Create_label(String name,Color color) {
            super(name);
            setFont(new Font("微软雅黑", 1, 40));
            setForeground(color);
            setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
    private class Create_Login_Button extends JButton{
        public Create_Login_Button(String text) {
            super(text);
            setBackground(new Color(0,191,255));
            setPreferredSize(new Dimension(215, 37));
            setForeground(Color.white);
            setFocusPainted(false);
            setFont(new Font("微软雅黑", 1, 15));
            setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    //见包中simpleLayout  抽象类
    private class SimpleLayout extends simpleLayout {

        @Override
        public void layoutContainer(Container parent) {
            // TODO 自动生成的方法存根
            Rectangle rect =parent.getBounds();
            if(bg.isVisible()){
                Dimension size=bg.getPreferredSize();
                bg.setBounds(0, -5, 440, 130);
            }
            if(users.isVisible()){
                Dimension size=users.getPreferredSize();
                int x=rect.width*1/5+15;
                int y=rect.height*1/2;
                users.setBounds(x, y, size.width, size.height);
            }
            if(userfield.isVisible()){
                Dimension size=userfield.getPreferredSize();
                int x=rect.width*1/5+30;
                int y=rect.height*1/2+1;
                userfield.setBounds(x, y, 215, 20);
            }
            if(codes.isVisible()){
                Dimension size=codes.getPreferredSize();
                int x=rect.width*1/5+15;
                int y=rect.height*1/2+42;
                codes.setBounds(x, y, size.width, size.height);
            }
            if(codefield.isVisible()){
                Dimension size=codefield.getPreferredSize();
                int x=rect.width*1/5+30;
                int y=rect.height*1/2+39;
                codefield.setBounds(x, y, 215, 20);
            }
            if(tx.isVisible()){
                Dimension size=tx.getPreferredSize();
                int x=(rect.width-size.width)/3+5;
                int y=44;
                tx.setBounds(x, y, size.width,size.height );
            }
            if(qq.isVisible()){
                Dimension size=qq.getPreferredSize();
                int x=(rect.width-size.width)/3+85;
                int y=42;
                qq.setBounds(x, y, size.width, size.height);
            }
            if(button.isVisible()){
                Dimension size=button.getPreferredSize();
                int x=(rect.width-size.width)/2+12;
                int y=rect.height*1/2+89;
                button.setBounds(x, y, size.width, size.height);
            }
            if(close.isVisible()){
                Dimension size=close.getPreferredSize();
                int x=rect.width-size.width;
                int y=0;
                close.setBounds(x, y, size.width, size.height);
            }
        }
    }
}

