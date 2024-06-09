package Views;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author pc
 */
public class callboard extends JFrame {
    private void insertNotice(String noticeContent, String noticeCreateTime) {
        // 这里需要根据你的数据库配置进行修改
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO announce (date, annText) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, noticeCreateTime);
            preparedStatement.setString(2, noticeContent);
            preparedStatement.executeUpdate();
            System.out.println("通告已成功插入到数据库中");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 修改 queryNoticesFromDatabase 方法，添加一个参数 time
    private String[][] queryNoticesFromDatabase(String time) {
        // 这里需要根据你的数据库配置进行修改
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "root";

        List<String[]> notices = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT date, annText FROM announce WHERE date = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, time);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String annText = resultSet.getString("annText");
                notices.add(new String[]{date, annText});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notices.toArray(new String[0][]);
    }
    private boolean isAnnounceExists(String date, String annText) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            String query = "SELECT * FROM announce WHERE date = ? AND annText = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, annText);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void deleteAnnounce(String date, String annText) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            String deleteQuery = "DELETE FROM announce WHERE date = ? AND annText = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, date);
            deleteStatement.setString(2, annText);
            deleteStatement.executeUpdate();
            Component contentPane = null;
            JOptionPane.showMessageDialog(contentPane, "删除成功！");
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private String[][] queryNoticesFromDatabase() {
        // 这里需要根据你的数据库配置进行修改
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "root";

        List<String[]> notices = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT date, annText FROM announce";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String annText = resultSet.getString("annText");
                notices.add(new String[]{date, annText});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notices.toArray(new String[0][]);
    }

    public callboard() {
        //窗体图标
        setTitle("学生宿舍管理");
        URL resource = Login.class.getClassLoader().getResource("Logo.png");
        Image image = new ImageIcon(resource).getImage();
        setIconImage(image);
        initComponents();
    }

    public String sendContent(String noticeContent){
        return noticeContent;
    }
    public String sendCreateTime(String noticeCreateTime){
        return noticeCreateTime;
    }

    private void updateTableData() {
        // 查询数据库，获取通告内容
        String[][] notices = queryNoticesFromDatabase();

        // 清空表格数据
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setRowCount(0);

        // 添加新的数据到表格中
        for (String[] notice : notices) {
            tableModel.addRow(notice);
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        addBtn = new JButton();

        deleteBtn = new JButton();
        editText = new JTextField();
        scrollPane1 = new JScrollPane();
        JTextField editText = new JTextField();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        createTime = new JTextField();
        label3 = new JLabel();
        selectBtn = new JButton();


        // 创建一个定时器，每隔5秒执行一次
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTableData();
            }
        });
        timer.start(); // 启动定时器
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- addBtn ----
        addBtn.setText("发布通告");
        contentPane.add(addBtn);
        addBtn.setBounds(new Rectangle(new Point(250, 310), addBtn.getPreferredSize()));
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noticeContent = editText.getText();
                String noticeCreateTime = createTime.getText();
                insertNotice(noticeContent, noticeCreateTime);
            }
        });

        // 创建一个DefaultTableModel对象，并设置给table1
        DefaultTableModel tableModel = new DefaultTableModel();
        table1.setModel(tableModel);

        deleteBtn.setText("删除通告");
        contentPane.add(deleteBtn);
        deleteBtn.setBounds(new Rectangle(new Point(350, 310), addBtn.getPreferredSize()));
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = createTime.getText(); // 获取输入的日期
                String annText = editText.getText(); // 获取输入的通告内容

                if (isAnnounceExists(date, annText)) {
                    deleteAnnounce(date, annText);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "未找到匹配的通告记录！");
                }
            }
        });

        // 添加列名
        tableModel.addColumn("创建时间");
        tableModel.addColumn("公告内容");

        // 添加数据（这里只是示例数据，你可以根据需要添加实际数据）
        tableModel.addRow(new Object[]{"示例公告1", "2022-01-01"});
        tableModel.addRow(new Object[]{"示例公告2", "2022-01-02"});

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(250, 40, 320, 100);

        //---- editText ----
        contentPane.add(editText);
        editText.setBounds(250, 195,190, 100);
        //---- label1 ----
        label1.setText("\u901a\u544a\u5185\u5bb9");
        contentPane.add(label1);
        label1.setBounds(145, 195, 65, 35);

        //---- label2 ----
        label2.setText("\u901a\u544a\u521b\u5efa\u65f6\u95f4");
        contentPane.add(label2);
        label2.setBounds(135, 150, 80, 35);
        contentPane.add(createTime);
        createTime.setBounds(250, 155, 165, 25);

        //---- label3 ----
        label3.setText("\u901a\u544a");
        contentPane.add(label3);
        label3.setBounds(175, 40, 50, 30);

        //---- selectBtn ----
        selectBtn.setText("\u67e5\u8be2\u901a\u544a");
        contentPane.add(selectBtn);
        selectBtn.setBounds(new Rectangle(new Point(435, 155), selectBtn.getPreferredSize()));
        // 修改 selectBtn 的 actionPerformed 方法
        selectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noticeCreateTime = createTime.getText();
                String[][] notices = queryNoticesFromDatabase(noticeCreateTime);
                if (notices.length > 0) {
                    editText.setText(notices[0][1]);
                } else {
                    editText.setText("");
                }
            }
        });


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
    private JTextField createTime;
    private JLabel label3;
    private JButton selectBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {

        new callboard().setVisible(true);

    }

}
