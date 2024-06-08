package org.example.Man_view;

import org.example.Connect.Connect;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentView extends JFrame {
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel genderLabel;
    private JLabel phoneLabel;
    private JLabel studentIdLabel;
    private JLabel ageLabel;
    private JLabel subjectLabel;
    private JLabel homeLabel;
    private JLabel bedLabel;

    public StudentView(String studentId) {
        setTitle("学生信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(9, 2));

        nameLabel = new JLabel("姓名: ");
        passwordLabel = new JLabel("密码: ");
        genderLabel = new JLabel("性别: ");
        phoneLabel = new JLabel("电话: ");
        studentIdLabel = new JLabel("学号: ");
        ageLabel = new JLabel("年龄: ");
        subjectLabel = new JLabel("专业: ");
        homeLabel = new JLabel("房号: ");
        bedLabel = new JLabel("床号: ");

        add(nameLabel);
        add(new JLabel()); // Empty label for spacing
        add(passwordLabel);
        add(new JLabel());
        add(genderLabel);
        add(new JLabel());
        add(phoneLabel);
        add(new JLabel());
        add(studentIdLabel);
        add(new JLabel());
        add(ageLabel);
        add(new JLabel());
        add(subjectLabel);
        add(new JLabel());
        add(homeLabel);
        add(new JLabel());
        add(bedLabel);
        add(new JLabel());

        fetchStudentInfo(studentId);

        setVisible(true);
    }

    private void fetchStudentInfo(String studentId) {
        try (Connection connection = Connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM student WHERE studentid = ?")) {
            statement.setString(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nameLabel.setText("姓名: " + resultSet.getString("name"));
                passwordLabel.setText("密码: " + resultSet.getString("password"));
                genderLabel.setText("性别: " + resultSet.getString("gender"));
                phoneLabel.setText("电话: " + resultSet.getString("phone"));
                studentIdLabel.setText("学号: " + resultSet.getString("studentid"));
                ageLabel.setText("年龄: " + resultSet.getInt("age"));
                subjectLabel.setText("专业: " + resultSet.getString("subject"));
                homeLabel.setText("房号: " + resultSet.getInt("home"));
                bedLabel.setText("床号: " + resultSet.getInt("bed"));
            } else {
                JOptionPane.showMessageDialog(this, "未找到该学生信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "获取学生信息失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}