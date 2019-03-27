package top.mapku.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.mapku.core.dto.UserDto;

import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE userId = #{id}")
    UserDto selectUserById(String id);

    @Select("SELECT * FROM user WHERE teamId = #{teamId}")
    List<UserDto> selectUsersByTeamId(Integer teamId);

    @Insert("INSERT user(userId, userName, registrationDate) VALUES (#{userId}, #{userName}, NOW())")
    void addUser(UserDto userDto);

    @Update("UPDATE user SET userName = #{userName}, avatarUrl = #{avatarUrl} WHERE userId = #{userId}")
    void updateUser(UserDto userDto);
}
