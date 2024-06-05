package org.example.Mapper;

import org.apache.ibatis.annotations.*;
import org.example.User_data.User_data;

import java.util.List;


public interface UserMapper {
    @Select("SELECT * FROM management_data WHERE man_username = #{id}")
    User_data getUserById(@Param("id") String id);

    @Select("SELECT * FROM management_data")
    List<User_data> getAllUsers();

    @Insert("INSERT INTO management_data (man_username, man_password, man_name, man_birthday, man_building, man_floor) VALUES (#{id}, #{password}, #{name}, #{birthday}, #{buildingNumber}, #{managedFloor})")
    void insertUser(User_data user);

    @Update("UPDATE management_data SET man_password = #{password}, man_name = #{name}, man_birthday = #{birthday}, man_building = #{buildingNumber}, man_floor = #{managedFloor} WHERE man_username = #{id}")
    void updateUser(User_data user);

    @Delete("DELETE FROM management_data WHERE man_username = #{id}")
    void deleteUser(@Param("id") String id);
}