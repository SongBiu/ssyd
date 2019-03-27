package top.mapku.core.service;

import top.mapku.core.entity.Moment;

import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public interface MomentService {
    List<Moment> getAllMoments();

    void addMoment(Moment moment);
}
