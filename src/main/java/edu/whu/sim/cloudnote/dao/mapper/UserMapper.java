package edu.whu.sim.cloudnote.dao.mapper;

import edu.whu.sim.cloudnote.dao.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Select("SELECT username FROM user WHERE id=#{id}")
    String getNameById(Integer id);

    @Select("SELECT id, username as userName, password as passWord FROM user WHERE username=#{username}")
    User findByName(String username);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO user (username, password, delete_flag, create_date) VALUES (#{username},#{password}, #{deleteFlag}, #{createDate})")
    int addUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteUser(Integer id);


}
