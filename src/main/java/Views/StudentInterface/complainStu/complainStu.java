/*
 * Created by JFormDesigner on Tue Jun 11 11:36:02 CST 2024
 */

package Views.StudentInterface.complainStu;

import Views.LoginAndRegisterView.LoginView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author pc
 */
public class complainStu extends JFrame {
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
    private void updateTable1() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM appeal");
                DefaultTableModel tableModel2 = (DefaultTableModel) table1.getModel();
                tableModel2.setRowCount(0);
                while (resultSet.next()) {
                    String stu = resultSet.getString("stu");
                    String msg = resultSet.getString("msg");
                    tableModel2.addRow(new Object[]{stu, msg});
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
    private void insertNotice(String noticeContent, String noticeCreateTime) {
        // 这里需要根据你的数据库配置进行修改
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO appeal (stu, msg) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, noticeCreateTime);
            preparedStatement.setString(2, noticeContent);
            preparedStatement.executeUpdate();
            System.out.println("通告已成功插入到数据库中");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public complainStu() {
        //窗体图标
        setTitle("学生宿舍管理");
        URL resource = LoginView.class.getClassLoader().getResource("Logo.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);
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

        Timer timer = new Timer(5000, e -> {
            if(isRefresh){
                updateTable1();
            }

        });
        timer.start();
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(200, 45, 285, 170);

        // 创建一个DefaultTableModel对象，并设置给table1
        DefaultTableModel tableModel = new DefaultTableModel();
        table1.setModel(tableModel);
        // 添加列名
        tableModel.addColumn("学生姓名");
        tableModel.addColumn("申诉信息");
        //---- label1 ----
        label1.setText("\u767b\u8bb0\u8868");
        contentPane.add(label1);
        label1.setBounds(200, 10, 65, 25);

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u8bb0\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(380, 330), button1.getPreferredSize()));
        button1.addActionListener(e -> {

            String name = textField1.getText();
            if (!name.isEmpty()) {
                isRefresh = false;
                Connection connection = getConnection();
                if (connection != null) {
                    try {
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM appeal WHERE stu='" + name + "'");
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
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stu = textField2.getText();
                String msg = textField1.getText();
                insertNotice(stu, msg);
            }
        });

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
    private boolean isRefresh = true;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new complainStu().setVisible(true);

    }
}
