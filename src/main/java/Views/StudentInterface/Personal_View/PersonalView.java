package Views.StudentInterface.Personal_View;


import Views.StudentInterface.Connect.Personal_Connect;
import Views.StudentInterface.Man_view.View;

import javax.swing.*;
import java.awt.*;
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

    private String username; // 登录的用户名

    public PersonalView(String username) {
        this.username = username;

        setTitle("宿管个人信息");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(6, 2));

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
        passwordField.setEditable(false);
        nameField.setEditable(false);
        birthdayField.setEditable(false);
        buildingField.setEditable(false);
        floorField.setEditable(false);

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

}

