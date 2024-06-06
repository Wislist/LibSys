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

    // 添加构造函数来接收表格数据
    public UpdateView(String name, String gender, String phone, String studentId, int age, String major, int homeId, int bedId) {
        initComponents(name, gender, phone, studentId, age, major, homeId, bedId);
    }

    private void initComponents(String name, String gender, String phone, String studentId, int age, String major, int homeId, int bedId) {
        setTitle("修改学生信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        // 添加输入框并设置初始值
        add(new JLabel("姓名:"));
        nameField = new JTextField(name);
        add(nameField);

        add(new JLabel("性别:"));
        genderField = new JTextField(gender);
        add(genderField);

        add(new JLabel("电话:"));
        phoneField = new JTextField(phone);
        add(phoneField);

        add(new JLabel("学号:"));
        studentIdField = new JTextField(studentId);
        add(studentIdField);

        add(new JLabel("年龄:"));
        ageField = new JTextField(String.valueOf(age));
        add(ageField);

        add(new JLabel("专业:"));
        sbField = new JTextField(major);
        add(sbField);

        add(new JLabel("房号:"));
        homeidField = new JTextField(String.valueOf(homeId));
        add(homeidField);

        add(new JLabel("床号:"));
        bedidField = new JTextField(String.valueOf(bedId));
        add(bedidField);

        // 添加按钮
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        updateButton = new JButton("更新");
        updateButton.addActionListener(e -> updateStudent());
        buttonPanel.add(updateButton);

        cancelButton = new JButton("取消");
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH); // 将按钮面板添加到窗口的底部
    }

    private void updateStudent() {
        try {
            // 获取输入框中的值
            String name = nameField.getText();
            String gender = genderField.getText();
            String phone = phoneField.getText();
            String studentId = studentIdField.getText();
            int age = Integer.parseInt(ageField.getText());
            String major = sbField.getText();
            String homeId = homeidField.getText();
            String bedId = bedidField.getText();

            // 更新数据库
            try (Connection connection = Connect.getConnection();
                 PreparedStatement statement = connection.prepareStatement(
                         "UPDATE student SET name = ?, gencher = ?, phone = ?, age = ?, subject = ?, home = ?, bed = ? WHERE studentid = ?")) {
                statement.setString(1, name);
                statement.setString(2, gender);
                statement.setString(3, phone);
                statement.setInt(4, age);
                statement.setString(5, major);
                statement.setString(6, homeId);
                statement.setString(7, bedId);
                statement.setString(8, studentId);
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