package Service;

import Pojo.AdminLogin;
import Pojo.StudentLogin;

public interface AdminService {

    /**
     * TODO:查询
     * @param admin
     * @return
     */
    boolean findById(AdminLogin admin);

    /**
     * TODO:添加
     * @param admin
     */
    void insert(AdminLogin admin);



}
