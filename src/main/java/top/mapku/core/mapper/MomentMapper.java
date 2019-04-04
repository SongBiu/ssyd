package top.mapku.core.mapper;

import org.apache.ibatis.annotations.*;
import top.mapku.core.entity.Moment;

import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Mapper
public interface MomentMapper {
    @Select("SELECT momentId, momentDate, user.userId, moment.bag, content, imageUrl, position, ssyd, good, userName, avatarUrl FROM moment JOIN user")
    List<Moment> selectAllMoments();

    @Select("SELECT momentId, momentDate, user.userId, moment.bag, content, imageUrl, position, ssyd, good, userName, avatarUrl FROM moment JOIN user WHERE momentId = #{momentId}")
    Moment selectMomentById(Integer momentId);

    @Select("SELECT * FROM moment WHERE userId = #{userId}")
    List<Moment> selectMomentsByUserId(String userId);

    @Insert("INSERT moment(momentDate, bag, content, imageUrl, position, ssyd, userId) VALUES (NOW(), #{bag}, #{content}, #{imageUrl}, #{position}, #{ssyd}, #{userId})")
    void insertMoment(Moment moment);

    @Delete("DELETE FROM moment WHERE momentId = #{momentId}")
    void delteMoment(Integer momentId);

    @Update("UPDATE moment SET good = #{good} WHERE momentId = #{momentId}")
    void updateGood(Moment moment);
}
