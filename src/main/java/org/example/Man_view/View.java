package org.example.Man_view;

import org.example.Connect.Connect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class View extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField, genderField, phoneField, studentIdField, ageField, sbField, homeidField, bedidField, searchField;

    public View() {
        initComponents();
        loadData();
    }

    private void initComponents() {
        setTitle("宿舍管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 添加搜索栏
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("请输入关键词:"));
        searchField = new JTextField(15);
        JButton searchButton = new JButton("搜索学生信息");
        searchButton.addActionListener(e -> searchUser());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        // 表格模型和表格
        tableModel = new DefaultTableModel(new String[]{"姓名", "性别", "电话", "学号", "年龄", "专业", "房号", "床号"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 添加和修改按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("新增学生信息");
        addButton.addActionListener(e -> addUser());
        buttonPanel.add(addButton);
        JButton updateButton = new JButton("修改学生信息");
        updateButton.addActionListener(e -> updateUser());
        buttonPanel.add(updateButton);
        JButton deleteButton = new JButton("删除学生信息");
        deleteButton.addActionListener(e -> deleteUser());
        buttonPanel.add(deleteButton);
        JButton loadButton = new JButton("刷新");
        loadButton.addActionListener(e -> loadData());
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // 添加表格行选择监听器
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // 将选中行的数据填充到文本框中
                    nameField.setText((String) table.getValueAt(selectedRow, 0));
                    genderField.setText((String) table.getValueAt(selectedRow, 1));
                    phoneField.setText((String) table.getValueAt(selectedRow, 2));
                    studentIdField.setText((String) table.getValueAt(selectedRow, 3));
                    ageField.setText(String.valueOf(table.getValueAt(selectedRow, 4)));
                    sbField.setText((String) table.getValueAt(selectedRow, 5));
                    homeidField.setText(String.valueOf(table.getValueAt(selectedRow, 6)));
                    bedidField.setText(String.valueOf(table.getValueAt(selectedRow, 7)));
                }
            }
        });
    }

    private void loadData() {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM student")) {

            // 清空表格数据
            tableModel.setRowCount(0);

            // 将数据库中的数据添加到表格
            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getString("name"),
                        resultSet.getString("gencher"),
                        resultSet.getString("phone"),
                        resultSet.getString("studentid"),
                        resultSet.getInt("age"),
                        resultSet.getString("subject"),
                        resultSet.getInt("home"),
                        resultSet.getInt("bed")
                };
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addUser() {
        // 实现添加学生信息的逻辑
        // 从表单中获取数据并插入到数据库中
        // 刷新表格数据
        loadData();
    }

    private void updateUser() {
        // 获取选中的行数据
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择要修改的学生", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // 创建 UpdateView 并将数据填充到输入框
        UpdateView updateView = new UpdateView(
                (String) table.getValueAt(selectedRow, 0),
                (String) table.getValueAt(selectedRow, 1),
                (String) table.getValueAt(selectedRow, 2),
                (String) table.getValueAt(selectedRow, 3),
                (Integer) table.getValueAt(selectedRow, 4),
                (String) table.getValueAt(selectedRow, 5),
                (Integer) table.getValueAt(selectedRow, 6),
                (Integer) table.getValueAt(selectedRow, 7)
        );

        updateView.setVisible(true);
        loadData();
    }

    private void deleteUser() {
        // 实现删除学生信息的逻辑
        // 从表格中获取选中的行,并从数据库中删除对应的记录
        // 刷新表格数据
        loadData();
    }

    private void searchUser() {
        // 实现搜索学生信息的逻辑
        // 从数据库中查询符合搜索条件的记录,并将结果展示在表格中
        // 刷新表格数据
        loadData();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new View().setVisible(true));
    }
}

