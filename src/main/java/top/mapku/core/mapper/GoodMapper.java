package top.mapku.core.mapper;

import org.apache.ibatis.annotations.*;
import top.mapku.core.entity.Good;

@Mapper
public interface GoodMapper {
    @Insert("INSERT good(userId, momentId) VALUES (#{userId}, #{momentId})")
    void insertGood(Good good);

    @Select("SELECT * FROM good WHERE userId = #{userId} AND momentId = #{momentId}")
    Good selectGood(Good good);

    @Delete("DELETE FROM good WHERE userId = #{userId} AND momentId = #{momentId}")
    void deleteGood(Good good);
}
