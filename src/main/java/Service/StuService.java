package Service;

import Pojo.AdminLogin;
import Pojo.StudentLogin;

public interface StuService {

    boolean findById(StudentLogin students);

    /**
     * TODO:添加
     * @param students
     */
    void insert(StudentLogin students);


    String findName(StudentLogin students);
}
