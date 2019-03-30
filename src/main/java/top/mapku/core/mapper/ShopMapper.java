package top.mapku.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.mapku.core.entity.User;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Mapper
public interface ShopMapper {
    @Select("SELECT code FROM verify WHERE userId = #{userId}")
    String selectCodeByUserId(String UserId);

    @Update("UPDATE user SET postcard = #{postcard}, voucher = #{voucher}, score = #{score} WHERE userId = #{userId}")
    void updateShop(User user);

}
