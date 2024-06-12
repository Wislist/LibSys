package Service.Impl;

import Pojo.AdminLogin;
import Pojo.StudentLogin;
import Service.AdminService;
import Utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminServiceImpl implements AdminService {

    AdminLogin admin;

    @Override
    public boolean findById(AdminLogin admin) {
        String sql = "select password from admin_login where id = ?";

        PreparedStatement ps = null;
        try {
            Connection connection = JdbcUtils.getInstance().getConnection();
            if (connection == null)     return false;
            ps = connection.prepareStatement(sql);
            ps.setString(1,admin.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String pwd = rs.getString(1);
                if (admin.getPassword().equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public void insert(AdminLogin admin) {
        String sql = "INSERT INTO admin_login (id, users, password) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            Connection connection = JdbcUtils.getInstance().getConnection();
            if (connection == null)     System.out.println("数据库连接错误");
            ps = connection.prepareStatement(sql);
            ps.setString(1,admin.getId());
            ps.setString(2,admin.getUsers());
            ps.setString(3,admin.getPassword());
            ps.executeQuery();
            System.out.println("插入成功safe~");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
