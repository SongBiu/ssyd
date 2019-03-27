package top.mapku.core.service.impl;

import org.springframework.stereotype.Component;
import top.mapku.core.dto.MomentDto;
import top.mapku.core.mapper.MomentMapper;
import top.mapku.core.service.MomentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Component
public class MomentServiceImpl implements MomentService {
    @Resource
    private MomentMapper momentMapper;

    @Override
    public List<MomentDto> getAllMoments() {
        return momentMapper.getAllMoments();
    }

    @Override
    public void addMoment(MomentDto momentDto) {

    }
}
