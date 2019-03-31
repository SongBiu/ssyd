package top.mapku.controller;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.aop.annotation.Auth;
import top.mapku.core.entity.Good;
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
    public List<Moment> getAllMoments() {
        return momentService.getAllMoments();
    }

    @DeleteMapping("/{momentId}")
    @Message(fail = "删除动态失败", success = "删除动态成功")
    @Auth
    public void deleteMoment(@PathVariable Integer momentId) {
        momentService.deleteMoment(momentId);
    }

    @PostMapping("/{momentId}")
    @Message(fail = "点赞失败", success = "点赞成功")
    @Auth
    public void giveGood(@PathVariable Integer momentId, @CookieValue("id") String userId) {
        momentService.giveGood(new Good(userId, momentId));
    }

//    @DeleteMapping("/{momentId}")
//    @Message(fail = "取消点赞失败", success = "取消点赞成功")
//    public void deleteGood(@PathVariable Integer momentId, @CookieValue("id") String userId) {
//        momentService.deleteGood(new Good(userId, momentId));
//    }

}
