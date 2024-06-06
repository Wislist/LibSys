package Mapper;


import Pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from Users where name = ")
    Users getByName(String name);

   // Users findByName(String name);

    @Insert("insert (name , password) values (#{name},#{password})")
    void insert(Users user);


    @Select("select * from Students where id = #{id}")
    Users getUserById(String id);
}
