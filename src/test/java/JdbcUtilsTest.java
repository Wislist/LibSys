import Utils.JdbcUtils;

import java.sql.*;

public class JdbcUtilsTest {
    public static void main(String[] args) {
        insertData(114514,"testuser","testpassword");
    }

    public static void findData(String username, String password){
        JdbcUtils jdbcUtils = JdbcUtils.getInstance();
        Connection connection = jdbcUtils.getConnection();

        if (connection != null) {
            System.out.println("数据库连接成功！");
            try {
                // 连接成功后可以进行一些操作
                // 例如查询数据库信息或执行一些SQL语句
                // 这里可以添加你的测试代码
                // 示例：执行查询操作
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
                // 处理结果集
                while (resultSet.next()) {
                    // 处理每一行数据
                }
                // 关闭结果集和语句
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("数据库连接失败！");
        }
    }
    public static void insertData(int id , String username, String password) {
        JdbcUtils jdbcUtils = JdbcUtils.getInstance();
        Connection connection = jdbcUtils.getConnection();

        if (connection != null) {
            try {
                String sql = "INSERT INTO students (id,name, password) VALUES (?,?, ?)";
                // 创建 PreparedStatement 对象
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                // 设置参数
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);

                // 执行插入操作
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("插入数据成功！");
                } else {
                    System.out.println("插入数据失败！");
                }

                // 关闭PreparedStatement
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("数据库连接失败！");
        }
    }

}
