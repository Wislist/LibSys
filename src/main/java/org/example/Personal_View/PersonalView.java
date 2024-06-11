package org.example.Personal_View;

import org.example.Connect.Connect;
import org.example.Connect.Personal_Connect;
import org.example.Man_view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalView extends JFrame {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel;
    private JLabel birthdayLabel;
    private JLabel buildingLabel;
    private JLabel floorLabel;

    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField nameField;
    private JTextField birthdayField;
    private JTextField buildingField;
    private JTextField floorField;

    private JButton modifyButton;
    private String username; // 登录的用户名

    public PersonalView(String username) {
        this.username = username;

        setTitle("宿管个人信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(7, 2)); // 增加一行用于修改按钮

        usernameLabel = new JLabel("用户名: ");
        passwordLabel = new JLabel("密码: ");
        nameLabel = new JLabel("姓名: ");
        birthdayLabel = new JLabel("生日: ");
        buildingLabel = new JLabel("管辖栋名: ");
        floorLabel = new JLabel("管辖层数: ");

        usernameField = new JTextField();
        passwordField = new JTextField();
        nameField = new JTextField();
        birthdayField = new JTextField();
        buildingField = new JTextField();
        floorField = new JTextField();

        // 设置所有字段为不可编辑
        usernameField.setEditable(false);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(nameLabel);
        add(nameField);
        add(birthdayLabel);
        add(birthdayField);
        add(buildingLabel);
        add(buildingField);
        add(floorLabel);
        add(floorField);

        modifyButton = new JButton("修改信息");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyInfo();
            }
        });
        add(new JLabel()); // 占位符
        add(modifyButton);

        fetchDormManagerInfo(username);

        setVisible(true);
    }

    private void fetchDormManagerInfo(String username) {
        try (Connection connection = Personal_Connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM management_data WHERE man_username = ?")) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usernameField.setText(resultSet.getString("man_username"));
                passwordField.setText(resultSet.getString("man_password"));
                nameField.setText(resultSet.getString("man_name"));
                birthdayField.setText(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("man_birthday")));
                buildingField.setText(resultSet.getString("man_building"));
                floorField.setText(resultSet.getString("man_floor"));
            } else {
                JOptionPane.showMessageDialog(this, "未找到该宿管信息", "错误", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "获取宿管信息失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void modifyInfo() {
        // 1. 获取修改后的信息
        String newName = nameField.getText();
        String newBirthday = birthdayField.getText();
        String newBuilding = buildingField.getText();
        String newFloor = floorField.getText();

        // 2. 验证信息（可以根据需要添加更多验证）
        if (newName.isEmpty() || newBirthday.isEmpty() || newBuilding.isEmpty() || newFloor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请填写所有信息", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. 更新数据库
        try (Connection connection = Personal_Connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE management_data SET man_name = ?, man_birthday = ?, man_building = ?, man_floor = ? WHERE man_username = ?")) {
            statement.setString(1, newName);
            statement.setString(2, newBirthday);
            statement.setString(3, newBuilding);
            statement.setString(4, newFloor);
            statement.setString(5, username);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "信息修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "信息修改失败", "错误", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "信息修改失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PersonalView("001").setVisible(true));
    }
}