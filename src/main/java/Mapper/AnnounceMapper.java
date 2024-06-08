package Mapper;

import Pojo.Announces;
import Pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: oyy0v0
 * @Date: 2024/6/7 - 06 - 07 - 23:54
 * @Description: Mapper
 * @version: 1.0
 */
@Mapper
public interface AnnounceMapper {
    @Select("select * from Announce where date = #{date}")
    Announces getByName(String date);

    // Users findByName(String name);

    @Insert("insert (date , annText) values (#{date},#{annText)})")
    void insert(Announces announces);


}
