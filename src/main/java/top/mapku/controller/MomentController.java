package top.mapku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.aop.annotation.NotAuth;
import top.mapku.core.entity.Moment;
import top.mapku.core.service.MomentService;

import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@RestController
@RequestMapping("/wxapp/moment")
public class MomentController {
    @Autowired
    private MomentService momentService;

    @GetMapping("")
    @Message(fail = "获取动态失败", success = "获取动态成功")
    @NotAuth
    public List<Moment> getAllMoments() {
        return momentService.getAllMoments();
    }
}
