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
     * @param id
     * @return
     */
    Users login(String id);


}
