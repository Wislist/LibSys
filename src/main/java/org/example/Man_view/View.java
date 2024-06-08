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
    private JTextField passField;

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
        searchPanel.add(new JLabel("请输入关键信息:"));
        searchField = new JTextField(15);
        JButton searchButton = new JButton("搜索学生信息");
        searchButton.addActionListener(e -> searchUser());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        // 表格模型和表格

        tableModel = new DefaultTableModel(new String[]{"姓名","密码", "性别", "电话", "学号", "年龄", "专业", "房号", "床号"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setAutoCreateRowSorter(true);
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
                    passField.setText((String) table.getValueAt(selectedRow,1));
                    genderField.setText((String) table.getValueAt(selectedRow, 2));
                    phoneField.setText((String) table.getValueAt(selectedRow, 3));
                    studentIdField.setText((String) table.getValueAt(selectedRow, 4));
                    ageField.setText(String.valueOf(table.getValueAt(selectedRow, 5)));
                    sbField.setText((String) table.getValueAt(selectedRow, 6));
                    homeidField.setText(String.valueOf(table.getValueAt(selectedRow, 7)));
                    bedidField.setText(String.valueOf(table.getValueAt(selectedRow, 8)));
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
                        resultSet.getString("password"),
                        resultSet.getString("gender"),
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
        addView addView = new addView();
        addView.setVisible(true);
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
                (String) table.getValueAt(selectedRow,1),
                (String) table.getValueAt(selectedRow, 2),
                (String) table.getValueAt(selectedRow, 3),
                (String) table.getValueAt(selectedRow, 4),
                (Integer) table.getValueAt(selectedRow, 5),
                (String) table.getValueAt(selectedRow, 6),
                (Integer) table.getValueAt(selectedRow, 7),
                (Integer) table.getValueAt(selectedRow, 8)
        );

        updateView.setVisible(true);
        loadData();
    }

    private void deleteUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String studentId = (String) table.getValueAt(selectedRow, 3);
            if (confirmDelete(studentId)) {
                try (Connection connection = Connect.getConnection();
                     PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE studentid = ?")) {
                    statement.setString(1, studentId);
                    statement.executeUpdate();
                    tableModel.removeRow(selectedRow); // 从表格中删除行
                    JOptionPane.showMessageDialog(this, "学生信息已删除", "成功", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "删除学生信息失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "请先选择要删除的学生信息", "提示", JOptionPane.WARNING_MESSAGE);
        }
        loadData();
    }

    private boolean confirmDelete(String studentId) {
        return JOptionPane.showConfirmDialog(this, "确定要删除学号为 " + studentId + " 的学生信息吗？", "确认删除", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    private void searchUser() {
        String searchTerm = searchField.getText().trim();
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入搜索关键词", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection connection = Connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM student WHERE name LIKE ? OR studentid LIKE ? OR phone LIKE ? OR gender LIKE ? OR password LIKE ? OR age LIKE ? OR subject LIKE ? OR home LIKE ? OR bed LIKE ? ")) {
            statement.setString(1, "%" + searchTerm + "%");
            statement.setString(2, "%" + searchTerm + "%");
            statement.setString(3, "%" + searchTerm + "%");
            statement.setString(4, "%" + searchTerm + "%");
            statement.setString(5, "%" + searchTerm + "%");
            statement.setInt(6, Integer.parseInt(searchTerm));
            statement.setString(7, "%" + searchTerm + "%");
            statement.setInt(8, Integer.parseInt(searchTerm));
            statement.setInt(9, Integer.parseInt(searchTerm));
            ResultSet resultSet = statement.executeQuery();

            // 清空表格
            tableModel.setRowCount(0);

            // 将所有搜索结果添加到表格中
            while (resultSet.next()) { // 遍历所有结果
                Object[] rowData = {
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("studentid"),
                        resultSet.getInt("age"),
                        resultSet.getString("subject"),
                        resultSet.getInt("home"),
                        resultSet.getInt("bed")
                };
                tableModel.addRow(rowData);
            }

            if (tableModel.getRowCount() == 0) { // 检查是否找到结果
                JOptionPane.showMessageDialog(this, "未找到匹配的学生信息", "提示", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "搜索学生信息失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new View().setVisible(true));
    }
}

