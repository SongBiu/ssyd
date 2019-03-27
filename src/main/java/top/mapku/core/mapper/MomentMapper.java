package top.mapku.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.mapku.core.entity.Moment;

import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Mapper
public interface MomentMapper {
    @Select("SELECT * FROM moment")
    List<Moment> getAllMoments();
}
