/*
 * Created by JFormDesigner on Thu Jun 06 13:21:39 CST 2024
 */

package Views.StudentInterface.StuInformation;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author 阿苗
 */
public class StuInformation extends JFrame {
    public StuInformation() {
        initComponents();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("student");
        panel1 = new JPanel();
        panel2 = new JPanel();
        textField1 = new JTextField();
        label1 = new JLabel();
        panel3 = new JPanel();
        textField2 = new JTextField();
        label2 = new JLabel();
        panel4 = new JPanel();
        textField3 = new JTextField();
        label3 = new JLabel();
        panel5 = new JPanel();
        textField4 = new JTextField();
        label4 = new JLabel();
        panel6 = new JPanel();
        textField5 = new JTextField();
        label5 = new JLabel();
        panel9 = new JPanel();
        textField8 = new JTextField();
        label8 = new JLabel();
        panel7 = new JPanel();
        textField6 = new JTextField();
        label6 = new JLabel();
        panel10 = new JPanel();
        textField9 = new JTextField();
        label9 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setLayout(null);

                //---- textField1 ----
                textField1.setEditable(false);
                panel2.add(textField1);
                textField1.setBounds(128, 5, 332, 35);

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

                //---- textField2 ----
                textField2.setEditable(false);
                textField2.setHorizontalAlignment(SwingConstants.CENTER);
                panel3.add(textField2);
                textField2.setBounds(128, 5, 107, 35);

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

                //---- textField3 ----
                textField3.setEditable(false);
                textField3.setHorizontalAlignment(SwingConstants.CENTER);
                panel4.add(textField3);
                textField3.setBounds(128, 5, 332, 35);

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

                //---- textField4 ----
                textField4.setEditable(false);
                panel5.add(textField4);
                textField4.setBounds(128, 5, 332, 35);

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

                //---- textField5 ----
                textField5.setEditable(false);
                textField5.setHorizontalAlignment(SwingConstants.CENTER);
                panel6.add(textField5);
                textField5.setBounds(128, 5, 332, 35);

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

                //---- textField8 ----
                textField8.setEditable(false);
                textField8.setHorizontalAlignment(SwingConstants.CENTER);
                panel9.add(textField8);
                textField8.setBounds(105, 5, 107, 35);

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

                //---- textField6 ----
                textField6.setEditable(false);
                textField6.setHorizontalAlignment(SwingConstants.CENTER);
                panel7.add(textField6);
                textField6.setBounds(128, 5, 107, 35);

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

                //---- textField9 ----
                textField9.setEditable(false);
                textField9.setHorizontalAlignment(SwingConstants.CENTER);
                panel10.add(textField9);
                textField9.setBounds(105, 5, 107, 35);

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
    }

    public static void main(String[] args) {
        new StuInformation().setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JTextField textField1;
    private JLabel label1;
    private JPanel panel3;
    private JTextField textField2;
    private JLabel label2;
    private JPanel panel4;
    private JTextField textField3;
    private JLabel label3;
    private JPanel panel5;
    private JTextField textField4;
    private JLabel label4;
    private JPanel panel6;
    private JTextField textField5;
    private JLabel label5;
    private JPanel panel9;
    private JTextField textField8;
    private JLabel label8;
    private JPanel panel7;
    private JTextField textField6;
    private JLabel label6;
    private JPanel panel10;
    private JTextField textField9;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
