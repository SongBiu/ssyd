package top.mapku.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mapku.core.dto.TeamDto;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@Mapper
public interface TeamMapper {
    @Select("SELECT * FROM team WHERE teamId = #{id}")
    TeamDto getTeamById(String id);

    @Select("SELECT * FROM team WHERE teamId = (SELECT teamId FROM user WHERE userId = #{userId})")
    TeamDto getTeamByUserId(String userId);
}
