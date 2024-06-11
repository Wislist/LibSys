package org.example.Man_view;

import org.example.Connect.Connect;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateView extends JFrame {
    private JTextField nameField, genderField, phoneField, studentIdField, ageField, sbField, homeidField, bedidField;
    private JButton updateButton, cancelButton;
    private JTextField passwordField;

    // 添加构造函数来接收表格数据
    public UpdateView(String name,String password, String gender, String phone, String studentId, int age, String major, int homeId, int bedId) {
        initComponents(name, password, gender, phone, studentId, age, major, homeId, bedId);
    }

    private void initComponents(String name,String password, String gender, String phone, String studentId, int age, String major, int homeId, int bedId) {
        setTitle("修改学生信息");
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
        nameField = new JTextField(name);
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("密码:"));
        passwordField = new JTextField(gender);
        inputPanel.add(passwordField);

        inputPanel.add(new JLabel("性别:"));
        genderField = new JTextField(gender);
        inputPanel.add(genderField);

        inputPanel.add(new JLabel("电话:"));
        phoneField = new JTextField(phone);
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("学号:"));
        studentIdField = new JTextField(studentId);
        studentIdField.setEditable(false);
        inputPanel.add(studentIdField);

        inputPanel.add(new JLabel("年龄:"));
        ageField = new JTextField(String.valueOf(age));
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("专业:"));
        sbField = new JTextField(major);
        inputPanel.add(sbField);

        inputPanel.add(new JLabel("房号:"));
        homeidField = new JTextField(String.valueOf(homeId));
        inputPanel.add(homeidField);

        inputPanel.add(new JLabel("床号:"));
        bedidField = new JTextField(String.valueOf(bedId));
        inputPanel.add(bedidField);

        // 添加按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        updateButton = new JButton("更新");
        updateButton.addActionListener(e -> updateStudent());
        buttonPanel.add(updateButton);

        cancelButton = new JButton("取消");
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(cancelButton);

        // 将输入面板和按钮面板添加到主面板
        contentPane.add(inputPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // 将主面板添加到窗口
        add(contentPane);
    }

    private void updateStudent() {
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
                         "UPDATE student SET name = ?,password = ?, gender = ?, phone = ?, age = ?, subject = ?, home = ?, bed = ? where studentid = ?")) {
                statement.setString(1, name);
                statement.setString(2,password);
                statement.setString(3, gender);
                statement.setString(4, phone);
                statement.setInt(5, age);
                statement.setString(6, major);
                statement.setInt(7, homeId);
                statement.setInt(8, bedId);
                statement.setString(9, studentId);

                statement.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "学生信息已更新", "成功", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // 关闭当前窗口
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "更新学生信息失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}