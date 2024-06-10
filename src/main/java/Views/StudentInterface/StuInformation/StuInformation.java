/*
 * Created by JFormDesigner on Thu Jun 06 13:21:39 CST 2024
 */

package Views.StudentInterface.StuInformation;

import Utils.Connect;
import Pojo.Student;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

/**
 * @author 阿苗
 */
public class StuInformation extends JFrame {
    Student student;
    public StuInformation() {
        initComponents(student);
    }
    public StuInformation(Student student){
        this.student=student;
        initComponents(student);
    }
    private void Stuselect(Student student) {
        Connect connect=new Connect();
        try(Connection connection=connect.getConnection()) {
            System.out.println("数据库连接成功");
            try(Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery("select * from student where studentid='"+student.StuID+"'");
                // 处理查询结果
                while (rs.next()) {
                    // 获取数据
                    student.phone = rs.getString("phone");
                    student.age= rs.getInt("age");
                    student.sex= rs.getString("gencher");
                    student.major= rs.getString("subject");
                    student.dormID=rs.getInt("home");
                    student.bedID=rs.getInt("bed");


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
    public void AddStuInformation(Student student){
        //数据写入
        nametext.setText(student.name);
        IDtext.setText(student.StuID);
        phonetext.setText(student.phone);
        sextext.setText(student.sex);
        majortext.setText(student.major);
        agetext.setText(String.valueOf(student.age));
        dormtext.setText(String.valueOf(student.dormID));
        bedtext.setText(String.valueOf(student.bedID));

    }
    private void initComponents(Student student) {
        Stuselect(student);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("student");
        panel1 = new JPanel();
        panel2 = new JPanel();
        nametext = new JTextField();
        label1 = new JLabel();
        panel3 = new JPanel();
        sextext = new JTextField();
        label2 = new JLabel();
        panel4 = new JPanel();
        IDtext = new JTextField();
        label3 = new JLabel();
        panel5 = new JPanel();
        phonetext = new JTextField();
        label4 = new JLabel();
        panel6 = new JPanel();
        majortext = new JTextField();
        label5 = new JLabel();
        panel9 = new JPanel();
        agetext = new JTextField();
        label8 = new JLabel();
        panel7 = new JPanel();
        dormtext = new JTextField();
        label6 = new JLabel();
        panel10 = new JPanel();
        bedtext = new JTextField();
        label9 = new JLabel();
        panel8 = new JPanel();

        //======== this ========
        setTitle(bundle.getString("StuInformation.this.title"));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //---- nametext ----
                nametext.setEditable(false);
                nametext.setFont(nametext.getFont().deriveFont(nametext.getFont().getSize() + 5f));
                panel2.add(nametext);
                nametext.setBounds(128, 5, 332, 35);

                //---- label1 ----
                label1.setText(bundle.getString("StuInformation.label1.text"));
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
            panel1.add(panel2);
            panel2.setBounds(0, 20, 475, 45);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //---- sextext ----
                sextext.setEditable(false);
                sextext.setHorizontalAlignment(SwingConstants.CENTER);
                sextext.setFont(sextext.getFont().deriveFont(sextext.getFont().getSize() + 5f));
                panel3.add(sextext);
                sextext.setBounds(128, 5, 107, 35);

                //---- label2 ----
                label2.setText(bundle.getString("StuInformation.label2.text"));
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
            panel1.add(panel3);
            panel3.setBounds(0, 80, 250, 45);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                //---- IDtext ----
                IDtext.setEditable(false);
                IDtext.setHorizontalAlignment(SwingConstants.CENTER);
                IDtext.setFont(IDtext.getFont().deriveFont(IDtext.getFont().getSize() + 5f));
                panel4.add(IDtext);
                IDtext.setBounds(128, 5, 332, 35);

                //---- label3 ----
                label3.setText(bundle.getString("StuInformation.label3.text"));
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 6f));
                panel4.add(label3);
                label3.setBounds(25, 5, 85, 35);

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
            panel1.add(panel4);
            panel4.setBounds(0, 130, 475, 45);

            //======== panel5 ========
            {
                panel5.setLayout(null);

                //---- phonetext ----
                phonetext.setEditable(false);
                phonetext.setHorizontalAlignment(SwingConstants.CENTER);
                phonetext.setFont(phonetext.getFont().deriveFont(phonetext.getFont().getSize() + 5f));
                panel5.add(phonetext);
                phonetext.setBounds(128, 5, 332, 35);

                //---- label4 ----
                label4.setText(bundle.getString("StuInformation.label4.text"));
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 6f));
                panel5.add(label4);
                label4.setBounds(25, 5, 85, 35);

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
            panel1.add(panel5);
            panel5.setBounds(0, 180, 475, 45);

            //======== panel6 ========
            {
                panel6.setLayout(null);

                //---- majortext ----
                majortext.setEditable(false);
                majortext.setHorizontalAlignment(SwingConstants.CENTER);
                majortext.setFont(majortext.getFont().deriveFont(majortext.getFont().getSize() + 5f));
                panel6.add(majortext);
                majortext.setBounds(128, 5, 332, 35);

                //---- label5 ----
                label5.setText(bundle.getString("StuInformation.label5.text"));
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 6f));
                panel6.add(label5);
                label5.setBounds(25, 5, 85, 35);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel6.getComponentCount(); i++) {
                        Rectangle bounds = panel6.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel6.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel6.setMinimumSize(preferredSize);
                    panel6.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel6);
            panel6.setBounds(0, 230, 475, 45);

            //======== panel9 ========
            {
                panel9.setLayout(null);

                //---- agetext ----
                agetext.setEditable(false);
                agetext.setHorizontalAlignment(SwingConstants.CENTER);
                agetext.setFont(agetext.getFont().deriveFont(agetext.getFont().getSize() + 5f));
                panel9.add(agetext);
                agetext.setBounds(105, 5, 107, 35);

                //---- label8 ----
                label8.setText(bundle.getString("StuInformation.label8.text"));
                label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 6f));
                panel9.add(label8);
                label8.setBounds(25, 5, 85, 35);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel9.getComponentCount(); i++) {
                        Rectangle bounds = panel9.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel9.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel9.setMinimumSize(preferredSize);
                    panel9.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel9);
            panel9.setBounds(250, 80, 250, 45);

            //======== panel7 ========
            {
                panel7.setLayout(null);

                //---- dormtext ----
                dormtext.setEditable(false);
                dormtext.setHorizontalAlignment(SwingConstants.CENTER);
                dormtext.setFont(dormtext.getFont().deriveFont(dormtext.getFont().getSize() + 5f));
                panel7.add(dormtext);
                dormtext.setBounds(128, 5, 107, 35);

                //---- label6 ----
                label6.setText(bundle.getString("StuInformation.label6.text"));
                label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 6f));
                panel7.add(label6);
                label6.setBounds(25, 5, 85, 35);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel7.getComponentCount(); i++) {
                        Rectangle bounds = panel7.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel7.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel7.setMinimumSize(preferredSize);
                    panel7.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel7);
            panel7.setBounds(0, 280, 250, 45);

            //======== panel10 ========
            {
                panel10.setLayout(null);

                //---- bedtext ----
                bedtext.setEditable(false);
                bedtext.setHorizontalAlignment(SwingConstants.CENTER);
                bedtext.setFont(bedtext.getFont().deriveFont(bedtext.getFont().getSize() + 5f));
                panel10.add(bedtext);
                bedtext.setBounds(105, 5, 107, 35);

                //---- label9 ----
                label9.setText(bundle.getString("StuInformation.label9.text"));
                label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 6f));
                panel10.add(label9);
                label9.setBounds(25, 5, 85, 35);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel10.getComponentCount(); i++) {
                        Rectangle bounds = panel10.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel10.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel10.setMinimumSize(preferredSize);
                    panel10.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel10);
            panel10.setBounds(250, 280, 250, 45);

            //======== panel8 ========
            {
                panel8.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel8.getComponentCount(); i++) {
                        Rectangle bounds = panel8.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel8.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel8.setMinimumSize(preferredSize);
                    panel8.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel8);
            panel8.setBounds(0, 330, 500, 20);

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
        panel1.setBounds(0, 5, 510, 360);

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

    }

    public static void main(String[] args) {
//        new StuInformation().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JTextField nametext;
    private JLabel label1;
    private JPanel panel3;
    private JTextField sextext;
    private JLabel label2;
    private JPanel panel4;
    private JTextField IDtext;
    private JLabel label3;
    private JPanel panel5;
    private JTextField phonetext;
    private JLabel label4;
    private JPanel panel6;
    private JTextField majortext;
    private JLabel label5;
    private JPanel panel9;
    private JTextField agetext;
    private JLabel label8;
    private JPanel panel7;
    private JTextField dormtext;
    private JLabel label6;
    private JPanel panel10;
    private JTextField bedtext;
    private JLabel label9;
    private JPanel panel8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
