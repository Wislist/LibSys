package Service.Impl;

import Pojo.StudentLogin;
import Service.StuService;
import Utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StuServiceImpl implements StuService {


    @Override
    public boolean findById(StudentLogin students) {
        String sql = "select password from stu_login where stu_id = ?";

        PreparedStatement ps = null;
        try {
            Connection connection = JdbcUtils.getInstance().getConnection();
            if (connection == null){
                return false;
            }
            ps = connection.prepareStatement(sql);
            ps.setString(1,students.getStuID());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String pwd = rs.getString(1);
                if (students.getPassword().equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void insert(StudentLogin students) {
        String sql = "INSERT INTO stu_login (stu_id, name , password) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            Connection connection = JdbcUtils.getInstance().getConnection();
            if (connection == null)     System.out.println("数据库连接错误");
            ps = connection.prepareStatement(sql);
            ps.setString(1,students.getStuID());
            ps.setString(2,students.getName());
            ps.setString(3,students.getPassword());
            ps.executeUpdate();
            System.out.println("插入成功safe~");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String findName(StudentLogin students) {
        String name = null;
        String sql = "SELECT name FROM stu_login WHERE stu_id = ?";
        PreparedStatement ps = null;
        try {
            Connection connection = JdbcUtils.getInstance().getConnection();
            if (connection == null) {
                return null;
            }
            ps = connection.prepareStatement(sql);
            ps.setString(1, students.getStuID());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                name = rs.getString("姓名");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close PreparedStatement and Connection in finally block
            // to ensure they are always closed even if an exception occurs
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Close connection

        }
        return name;
    }


}
