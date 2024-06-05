package org.example.Man_view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField, genderField, phoneField, studentIdField, ageField, sbField;
    private JTextField homeidField;
    private JTextField searchField;
    private JTextField bedidField;

    public View() {
        initComponents();
    }



    private void initComponents() {
        setTitle("宿舍管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // 添加搜索栏
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("请输入关键词:",SwingConstants.CENTER));
        searchField = new JTextField(15);
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchUser();
            }
        });
        JButton searchButton = new JButton("搜索学生信息");
        searchButton.addActionListener(e -> searchUser());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        // 表格模型和表格
        tableModel = new DefaultTableModel(new String[]{ "姓名", "性别", "电话", "学号", "年龄", "专业","房号","床号"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

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
        JButton addButton = new JButton("新增学生信息");
        addButton.setPreferredSize(new Dimension(150, 30));
        addButton.addActionListener(e -> addUser());

        JButton updateButton = new JButton("修改学生信息");
        updateButton.setPreferredSize(new Dimension(150, 30));
        updateButton.addActionListener(e -> updateUser());

        JButton deleteButton = new JButton("删除学生信息");
        deleteButton.setPreferredSize(new Dimension(150, 30));
        deleteButton.addActionListener(e -> deleteUser());



        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addUser() {

    }

    private void updateUser() {
        UpdateView updateView = new UpdateView();
        // 设置 UpdateView 为可见
        updateView.setVisible(true);
    }

    private void deleteUser() {

    }
    private void searchUser(){

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new View().setVisible(true));
    }

}