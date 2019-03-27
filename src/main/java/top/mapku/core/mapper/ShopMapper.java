package top.mapku.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Mapper
public interface ShopMapper {
    @Select("SELECT code FROM verify WHERE userId = #{userId}")
    String selectCodeByUserId(String UserId);
}
