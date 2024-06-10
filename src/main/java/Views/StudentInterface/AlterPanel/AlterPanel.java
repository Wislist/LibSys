/*
 * Created by JFormDesigner on Sat Jun 08 15:37:55 CST 2024
 */

package Views.StudentInterface.AlterPanel;

import Views.StudentInterface.StuAlter.StuAlter;
import Views.StudentInterface.StuAlterPho.StuAlterPho;
import Views.StudentInterface.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author 阿苗
 */
public class AlterPanel extends JFrame {
    Student student;
    public AlterPanel() {
        initComponents(student);
    }
    public AlterPanel(Student student){
        this.student=student;
        initComponents(student);
    }
    public void AddButtonFunction(Student student){
        AlterPasswordbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StuAlter stuAlter=new StuAlter(student);
                stuAlter.setVisible(true);
            }
        });
        AlterPhobutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StuAlterPho stuAlterPho=new StuAlterPho(student);
                stuAlterPho.setVisible(true);
            }
        }
        );
    }
    private void initComponents(Student student) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("student");
        dialogPane = new JPanel();
        panel1 = new JPanel();
        AlterPasswordbutton = new JButton();
        AlterPhobutton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new FlowLayout());

                //---- AlterPasswordbutton ----
                AlterPasswordbutton.setText(bundle.getString("AlterPanel.AlterPasswordbutton.text"));
                panel1.add(AlterPasswordbutton);

                //---- AlterPhobutton ----
                AlterPhobutton.setText(bundle.getString("AlterPanel.AlterPhobutton.text"));
                panel1.add(AlterPhobutton);
            }
            dialogPane.add(panel1, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        AddButtonFunction(student);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel panel1;
    private JButton AlterPasswordbutton;
    private JButton AlterPhobutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
