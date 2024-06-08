package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 * @author pc
 */
public class callboard extends JFrame {
    public callboard() {
        //窗体图标
        setTitle("学生宿舍管理");
        URL resource = Login.class.getClassLoader().getResource("Logo.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);
        initComponents();

    }

    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        addBtn = new JButton();
        deleteBtn = new JButton();
        editText = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        selectBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- addBtn ----
        addBtn.setText("\u53d1\u5e03\u901a\u544a");
        contentPane.add(addBtn);
        addBtn.setBounds(new Rectangle(new Point(250, 310), addBtn.getPreferredSize()));
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里实现发送数据的逻辑
                String noticeContent = editText.getText();
                String noticeCreateTime = textField1.getText();
                System.out.println("这里数据获取成功");
                System.out.println("发布通告内容：" + noticeContent);
                System.out.println("发布时间：" + noticeCreateTime);
            }
        });

        //---- deleteBtn ----
        deleteBtn.setText("\u5220\u9664\u901a\u544a");
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(new Rectangle(new Point(380, 310), deleteBtn.getPreferredSize()));
        contentPane.add(editText);
        editText.setBounds(245, 190, 220, 100);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(250, 40, 320, 100);

        //---- label1 ----
        label1.setText("\u901a\u544a\u5185\u5bb9");
        contentPane.add(label1);
        label1.setBounds(145, 195, 65, 35);

        //---- label2 ----
        label2.setText("\u901a\u544a\u521b\u5efa\u65f6\u95f4");
        contentPane.add(label2);
        label2.setBounds(135, 150, 80, 35);
        contentPane.add(textField1);
        textField1.setBounds(250, 155, 165, 25);

        //---- label3 ----
        label3.setText("\u901a\u544a");
        contentPane.add(label3);
        label3.setBounds(175, 40, 50, 30);

        //---- selectBtn ----
        selectBtn.setText("\u67e5\u8be2\u901a\u544a");
        contentPane.add(selectBtn);
        selectBtn.setBounds(new Rectangle(new Point(435, 155), selectBtn.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton addBtn;
    private JButton deleteBtn;
    private JTextField editText;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JButton selectBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new callboard().setVisible(true);

    }

}
