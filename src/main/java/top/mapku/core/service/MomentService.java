package top.mapku.core.service;

import org.springframework.stereotype.Component;
import top.mapku.core.dto.MomentDto;

import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public interface MomentService {
    List<MomentDto> getAllMoments();

    void addMoment(MomentDto momentDto);
}
