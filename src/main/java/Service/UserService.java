package Service;

import Pojo.Users;

public interface UserService {

    /**
     * TODO:查询名字
     * @param users
     * @return
     */
    void Insert(Users users);


    /**
     * TODO:登录
     * @param users
     * @return
     */
    Users login(Users users);


}
