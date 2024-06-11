/*
 * Created by JFormDesigner on Tue Jun 11 09:58:18 CST 2024
 */

package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author pc
 */
public class complain extends JFrame {
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    private void updateTable() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM complain");
                DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
                tableModel.setRowCount(0);
                while (resultSet.next()) {
                    String stu = resultSet.getString("stu");
                    String msg = resultSet.getString("msg");
                    tableModel.addRow(new Object[]{stu, msg});
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public complain() {
        //窗体图标
        setTitle("学生宿舍管理");
        URL resource = Login.class.getClassLoader().getResource("Logo.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        textField2 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        Timer timer = new Timer(5000, e -> {
            if (isRefreshing) {
                updateTable();
            }
        });
        timer.start();


        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(285, 265, 215, 35);

        // 创建一个DefaultTableModel对象，并设置给table1
        DefaultTableModel tableModel = new DefaultTableModel();
        table1.setModel(tableModel);
        // 添加列名
        tableModel.addColumn("学生姓名");
        tableModel.addColumn("违纪信息");

        // 添加数据（这里只是示例数据，你可以根据需要添加实际数据）
        tableModel.addRow(new Object[]{"示例1", "你好"});
        tableModel.addRow(new Object[]{"示例2", "你好"});
        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(210, 65, 340, 135);



        //---- button1 ----
        button1.setText("\u53d1\u5e03\u8bb0\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(460, 310), button1.getPreferredSize()));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textField2Content = textField2.getText();
                String textField1Content = textField1.getText();

                if (!textField2Content.isEmpty() && !textField1Content.isEmpty()) {
                    Connection connection = getConnection();
                    if (connection != null) {
                        try {
                            Statement statement = connection.createStatement();
                            statement.executeUpdate("INSERT INTO complain (stu, msg) VALUES ('" + textField2Content + "', '" + textField1Content + "')");
                            JOptionPane.showMessageDialog(null, "发布成功");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                connection.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请输入学生姓名和消息内容");
                }
            }
        });

        contentPane.add(textField2);
        textField2.setBounds(290, 215, 205, 35);

        //---- label1 ----
        label1.setText("\u767b\u8bb0\u8868");
        contentPane.add(label1);
        label1.setBounds(210, 25, 55, 30);

        //---- label2 ----
        label2.setText("\u767b\u8bb0\u4fe1\u606f");
        contentPane.add(label2);
        label2.setBounds(215, 270, 60, 30);

        //---- label3 ----
        label3.setText("\u5b66\u751f");
        contentPane.add(label3);
        label3.setBounds(220, 220, 50, 30);

        //---- button2 ----
        button2.setText("\u5220\u9664\u8bb0\u5f55");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(345, 310), button2.getPreferredSize()));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textField1Content = textField2.getText();
                String textField2Content = textField1.getText();

                if (!textField1Content.isEmpty() && !textField2Content.isEmpty()) {
                    Connection connection = getConnection();
                    if (connection != null) {
                        try {
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM complain WHERE stu='" + textField1Content + "' AND msg='" + textField2Content + "'");
                            if (resultSet.next()) {
                                statement.executeUpdate("DELETE FROM complain WHERE stu='" + textField1Content + "' AND msg='" + textField2Content + "'");
                                JOptionPane.showMessageDialog(null, "删除成功");
                            } else {
                                JOptionPane.showMessageDialog(null, "未找到匹配的记录");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                connection.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请输入学生姓名和消息内容");
                }
            }
        });


        //---- button3 ----
        button3.setText("\u67e5\u770b\u8bb0\u5f55");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(230, 310), button3.getPreferredSize()));
        button3.addActionListener(e -> {
            isRefreshing = false;
            String name = textField2.getText();
            if (!name.isEmpty()) {
                Connection connection = getConnection();
                if (connection != null) {
                    try {
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM complain WHERE stu='" + name + "'");
                        tableModel.setRowCount(0);
                        while (resultSet.next()) {
                            String stu = resultSet.getString("stu");
                            String msg = resultSet.getString("msg");
                            tableModel.addRow(new Object[]{stu, msg});
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            connection.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入学生姓名");
            }
        });


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
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button2;
    private JButton button3;
    private boolean isRefreshing = true;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new complain().setVisible(true);

    }

}
