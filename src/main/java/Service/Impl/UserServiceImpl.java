package Service.Impl;

import Mapper.UserMapper;
import Pojo.Users;
import Service.UserService;

public class UserServiceImpl implements UserService {


    private UserMapper userMapper;

    @Override
    public void Insert(Users users) {
        userMapper.insert(users);
    }

    @Override
    public Users login(Users users) {
    //    Users loginUser = userMapper.getByNameAndPassword(users);
        return users;
    }
}
