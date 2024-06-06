package Service.Impl;

import Mapper.UserMapper;
import Pojo.Users;
import Service.UserService;
import Utils.JdbcUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;


public class UserServiceImpl implements UserService {


    private UserMapper userMapper;
    JdbcUtils jdbcUtils = JdbcUtils.getInstance();
    Connection connection = jdbcUtils.getConnection();

    @Override
    public void Insert(Users users) {
        userMapper.insert(users);
    }

    @Override
    public Users login(String id) {
    //    Users loginUser = userMapper.getByNameAndPassword(users);
        try (SqlSession session = (SqlSession) JdbcUtils.getInstance()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
