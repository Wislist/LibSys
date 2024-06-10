/*
 * Created by JFormDesigner on Thu Jun 06 13:07:41 CST 2024
 */

package Views.StudentInterface.StuMainInterface;

import Views.StudentInterface.AlterPanel.AlterPanel;
import Views.StudentInterface.StuInformation.StuInformation;
import Pojo.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author 阿苗
 */
public class StuMainInterface extends JFrame {
    Student student;
    public StuMainInterface() {
        initComponents();
    }
    public StuMainInterface(Student student){
        this.student=student;
        initComponents();

    }
    public void ButtonFunction(Student student){
        checkbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StuInformation stuInformation=new StuInformation(student);
                stuInformation.setVisible(true);

            }
        });
        alertbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AlterPanel alterPanel=new AlterPanel(student);
                alterPanel.setVisible(true);
            }
        });

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        ResourceBundle bundle = ResourceBundle.getBundle("student");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        button1 = new JButton();
        checkbutton = new JButton();
        alertbutton = new JButton();
        applybutton = new JButton();

        //======== this ========
        setTitle(bundle.getString("StuMainInterface.this.title"));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setBorder(new EtchedBorder());
                panel2.setLayout(null);

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
            panel2.setBounds(155, 30, 600, 400);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //---- button1 ----
                button1.setText(bundle.getString("StuMainInterface.button1.text"));
                panel3.add(button1);

                //---- checkbutton ----
                checkbutton.setText(bundle.getString("StuMainInterface.checkbutton.text"));
                panel3.add(checkbutton);

                //---- alertbutton ----
                alertbutton.setText(bundle.getString("StuMainInterface.alertbutton.text"));
                panel3.add(alertbutton);

                //---- applybutton ----
                applybutton.setText(bundle.getString("StuMainInterface.applybutton.text"));
                panel3.add(applybutton);
            }
            panel1.add(panel3);
            panel3.setBounds(30, 30, 110, 390);

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
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        //按钮功能实现
        ButtonFunction(student);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
//        Student student=new Student
//                ("张三", "123456", "男","2023001", 20,"13812345678" ,"计算机科学", 101, 1);
        Student student=new Student("张三", "123456","2023001");
        new StuMainInterface(student).setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton button1;
    private JButton checkbutton;
    private JButton alertbutton;
    private JButton applybutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
