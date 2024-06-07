/*
 * Created by JFormDesigner on Fri Jun 07 18:43:48 CST 2024
 */

package Views.StudentInterface.StuAlter;

import Views.Connect;
import Views.StudentInterface.Student;
import Views.StudentInterface.dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author 阿苗
 */
public class StuAlter extends JFrame {
    Student student;
    public StuAlter() {
        initComponents(student);
    }
    public StuAlter(Student student){
        this.student=student;
        initComponents(student);
    }
    public void StuSelect(Student student){
        Connect connect=new Connect();
        try(Connection connection=connect.getConnection()) {
            System.out.println("数据库连接成功");
            //查找
            try(Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery("select * from student where studentid='"+student.StuID+"'");
                // 处理查询结果
                while (rs.next()) {
                    student.name = rs.getString("name");
                    student.StuID = rs.getString("studentid");
                    student.password = rs.getString("password");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
    public void AddStuInformation(Student student){
        nametext.setText(student.name);
        IDtext.setText(student.StuID);
    }
    public void StuAlterFunction(Student student){
        Connect connect=new Connect();
        String sql="update student \n" +
                "set password=?\n" +
                "where studentid=?;";
        String oldpassword=oldPasswordtext.getText().toString();
        String newpassword= newPasswordtext.getText().toString();
        if (oldpassword.equals(student.password)){
            if (!newpassword.equals("")){
                try(Connection connection=connect.getConnection();
                    PreparedStatement pstmt =connection.prepareStatement(sql)) {

                    System.out.println("数据库连接成功");
                    //修改
                    pstmt.setString(1, newpassword);
                    pstmt.setString(2,student.StuID);
                    int result = pstmt.executeUpdate();
                    if (result > 0) {
                        System.out.println("密码修改成功");
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("数据库连接失败");
                }
            }
            else {
                System.out.println("请输入新密码");
                new dialog("请输入新密码");
            }
        }
        else{
            System.out.println("密码错误");
            new dialog("密码错误");
        }

    }

    private void initComponents(Student student) {
        StuSelect(student);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("student");
        panel2 = new JPanel();
        nametext = new JTextField();
        label1 = new JLabel();
        panel3 = new JPanel();
        oldPasswordtext = new JTextField();
        label2 = new JLabel();
        panel4 = new JPanel();
        newPasswordtext = new JTextField();
        label3 = new JLabel();
        Alterbutton = new JButton();
        panel1 = new JPanel();
        panel5 = new JPanel();
        IDtext = new JTextField();
        label4 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel2 ========
        {
            panel2.setLayout(null);

            //---- nametext ----
            nametext.setEditable(false);
            panel2.add(nametext);
            nametext.setBounds(128, 5, 200, 35);

            //---- label1 ----
            label1.setText(bundle.getString("StuAlter.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
            panel2.add(label1);
            label1.setBounds(25, 5, 80, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel2);
        panel2.setBounds(0, 20, 400, 45);

        //======== panel3 ========
        {
            panel3.setLayout(null);
            panel3.add(oldPasswordtext);
            oldPasswordtext.setBounds(128, 5, 200, 35);

            //---- label2 ----
            label2.setText(bundle.getString("StuAlter.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 6f));
            panel3.add(label2);
            label2.setBounds(25, 5, 80, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel3.getComponentCount(); i++) {
                    Rectangle bounds = panel3.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel3.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel3.setMinimumSize(preferredSize);
                panel3.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel3);
        panel3.setBounds(0, 140, 400, 45);

        //======== panel4 ========
        {
            panel4.setLayout(null);
            panel4.add(newPasswordtext);
            newPasswordtext.setBounds(128, 5, 200, 35);

            //---- label3 ----
            label3.setText(bundle.getString("StuAlter.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 6f));
            panel4.add(label3);
            label3.setBounds(25, 5, 80, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel4.getComponentCount(); i++) {
                    Rectangle bounds = panel4.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel4.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel4.setMinimumSize(preferredSize);
                panel4.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel4);
        panel4.setBounds(0, 200, 400, 45);

        //---- Alterbutton ----
        Alterbutton.setText(bundle.getString("StuAlter.Alterbutton.text"));
        contentPane.add(Alterbutton);
        Alterbutton.setBounds(120, 270, 103, 40);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(40, 320, 300, 30);

        //======== panel5 ========
        {
            panel5.setLayout(null);

            //---- IDtext ----
            IDtext.setEditable(false);
            panel5.add(IDtext);
            IDtext.setBounds(128, 5, 200, 35);

            //---- label4 ----
            label4.setText(bundle.getString("StuAlter.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 6f));
            panel5.add(label4);
            label4.setBounds(25, 5, 80, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel5.getComponentCount(); i++) {
                    Rectangle bounds = panel5.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel5.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel5.setMinimumSize(preferredSize);
                panel5.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel5);
        panel5.setBounds(0, 80, 400, 45);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        //数据写入
        AddStuInformation(student);
        Alterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StuAlterFunction(student);
            }
        });

    }

    public static void main(String[] args) {
        new StuAlter().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JTextField nametext;
    private JLabel label1;
    private JPanel panel3;
    private JTextField oldPasswordtext;
    private JLabel label2;
    private JPanel panel4;
    private JTextField newPasswordtext;
    private JLabel label3;
    private JButton Alterbutton;
    private JPanel panel1;
    private JPanel panel5;
    private JTextField IDtext;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
