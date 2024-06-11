/*
 * Created by JFormDesigner on Tue Jun 11 11:36:02 CST 2024
 */

package Views;

import java.awt.*;
import javax.swing.*;

/**
 * @author pc
 */
public class complainStu extends JFrame {
    public complainStu() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        label2 = new JLabel();
        button2 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(250, 45, 285, 170);

        //---- label1 ----
        label1.setText("\u767b\u8bb0\u8868");
        contentPane.add(label1);
        label1.setBounds(255, 10, 65, 25);

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u8bb0\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(380, 330), button1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(310, 240, 110, 35);

        //---- label2 ----
        label2.setText("\u5b66\u751f");
        contentPane.add(label2);
        label2.setBounds(240, 245, 45, 30);

        //---- button2 ----
        button2.setText("\u6dfb\u52a0\u8bb0\u5f55");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(280, 330), button2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u7533\u8bc9\u4fe1\u606f");
        contentPane.add(label3);
        label3.setBounds(230, 290, 65, 25);
        contentPane.add(textField2);
        textField2.setBounds(310, 290, 215, 35);

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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JTextField textField1;
    private JLabel label2;
    private JButton button2;
    private JLabel label3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
