package top.mapku.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.mapku.core.entity.User;

import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE userId = #{id}")
    User selectUserById(String id);

    @Select("SELECT * FROM user WHERE teamId = #{teamId}")
    List<User> selectUsersByTeamId(Integer teamId);

    @Select("SELECT * FROM user WHERE userId = (SELECT alpha FROM invite WHERE userId = #{userId}")
    User selectInviter(User user);

    @Insert("INSERT user(userId, userName, registrationDate) VALUES (#{userId}, #{userName}, NOW())")
    void insertUser(User user);

    @Update("UPDATE user SET userName = #{userName}, avatarUrl = #{avatarUrl} WHERE userId = #{userId}")
    void updateUser(User user);

}
