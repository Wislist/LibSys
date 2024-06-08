package org.example.Man_view;

import org.example.Connect.Connect;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addView extends JFrame {
    private JTextField nameField, genderField, phoneField, studentIdField, ageField, sbField, homeidField, bedidField;
    private JButton addButton, cancelButton; // 将按钮名称改为添加和取消
    private JTextField passwordField;

    // 添加构造函数来接收表格数据
    public addView() { // 去除构造函数中的参数，因为添加学生信息时不需要接收表格数据
        initComponents();
    }

    private void initComponents() {
        setTitle("添加学生信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        // 使用更合适的布局管理器
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 添加边距

        // 创建一个面板用于存放输入框
        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 10, 10));

        // 添加输入框并设置初始值
        inputPanel.add(new JLabel("姓名:"));
        nameField = new JTextField(); // 去除初始值
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("密码:"));
        passwordField = new JTextField(); // 去除初始值
        inputPanel.add(passwordField);


        inputPanel.add(new JLabel("性别:"));
        genderField = new JTextField(); // 去除初始值
        inputPanel.add(genderField);

        inputPanel.add(new JLabel("电话:"));
        phoneField = new JTextField(); // 去除初始值
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("学号:"));
        studentIdField = new JTextField(); // 去除初始值
        inputPanel.add(studentIdField);

        inputPanel.add(new JLabel("年龄:"));
        ageField = new JTextField(); // 去除初始值
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("专业:"));
        sbField = new JTextField(); // 去除初始值
        inputPanel.add(sbField);

        inputPanel.add(new JLabel("房号:"));
        homeidField = new JTextField(); // 去除初始值
        inputPanel.add(homeidField);

        inputPanel.add(new JLabel("床号:"));
        bedidField = new JTextField(); // 去除初始值
        inputPanel.add(bedidField);

        // 添加按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("添加"); // 将按钮名称改为添加
        addButton.addActionListener(e -> addStudent());
        buttonPanel.add(addButton);

        cancelButton = new JButton("取消");
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(cancelButton);

        // 将输入面板和按钮面板添加到主面板
        contentPane.add(inputPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // 将主面板添加到窗口
        add(contentPane);
    }

    private void addStudent() {
        try {
            // 获取输入框中的值
            String name = nameField.getText();
            String password = passwordField.getText();
            String gender = genderField.getText();
            String phone = phoneField.getText();
            String studentId = studentIdField.getText();
            int age = Integer.parseInt(ageField.getText());
            String major = sbField.getText();
            int homeId = Integer.parseInt(homeidField.getText());
            int bedId = Integer.parseInt(bedidField.getText());

            // 更新数据库
            try (Connection connection = Connect.getConnection();
                 PreparedStatement statement = connection.prepareStatement(
                         "INSERT INTO student (name,password, gender, phone, studentid, age, subject, home, bed) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)")) {
                statement.setString(1, name);
                statement.setString(2,password);
                statement.setString(3, gender);
                statement.setString(4, phone);
                statement.setString(5, studentId);
                statement.setInt(6, age);
                statement.setString(7, major);
                statement.setInt(8, homeId);
                statement.setInt(9, bedId);


                statement.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "学生信息已添加", "成功", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // 关闭当前窗口
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "添加学生信息失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}