package org.example.Man_view;

import javax.swing.*;
import java.awt.*;

public class UpdateView extends JFrame {
    private JTextField nameField, genderField, phoneField, studentIdField, ageField, sbField;
    private JTextField homeidField, bedidField;

    public UpdateView() {
        initComponents();
    }

    private void initComponents() {
        setTitle("更新学生信息");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 表单面板
        JPanel formPanel = new JPanel(new GridLayout(9, 2));
        formPanel.add(new JLabel("姓名:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        formPanel.add(new JLabel("性别:"));
        genderField = new JTextField();
        formPanel.add(genderField);
        formPanel.add(new JLabel("电话:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);
        formPanel.add(new JLabel("学号:"));
        studentIdField = new JTextField();
        formPanel.add(studentIdField);
        formPanel.add(new JLabel("年龄:"));
        ageField = new JTextField();
        formPanel.add(ageField);
        formPanel.add(new JLabel("专业:"));
        sbField = new JTextField();
        formPanel.add(sbField);
        formPanel.add(new JLabel("房号:"));
        homeidField = new JTextField();
        formPanel.add(homeidField);
        formPanel.add(new JLabel("床号:"));
        bedidField = new JTextField();
        formPanel.add(bedidField);

        // 添加和修改按钮
        JButton updateButton = new JButton("更新学生信息");
        updateButton.setPreferredSize(new Dimension(150, 30));
        updateButton.addActionListener(e -> updateStudent());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(updateButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateStudent() {
        // 这里应该有更新学生信息的逻辑
        // 例如使用MyBatis或JDBC
        System.out.println("更新学生信息");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new View().setVisible(true);
            new UpdateView().setVisible(true); // 确保UpdateView在创建时就可见
        });
    }
}