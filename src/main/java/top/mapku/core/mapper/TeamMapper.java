package top.mapku.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mapku.core.entity.Team;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@Mapper
public interface TeamMapper {
    @Select("SELECT * FROM team WHERE teamId = #{id}")
    Team selectTeamById(String id);

    @Select("SELECT * FROM team WHERE teamId = (SELECT teamId FROM user WHERE userId = #{userId})")
    Team selectTeamByUserId(String userId);
}
