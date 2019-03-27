package top.mapku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.aop.annotation.NotAuth;
import top.mapku.core.dto.TeamDto;
import top.mapku.core.service.TeamService;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@RestController
@RequestMapping("/wxapp/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    @Message(fail = "获取用户社团信息失败", success = "成功获取社团信息")
    public TeamDto getTeamByUserId(@CookieValue("id") String userId) {
        return teamService.getTeamByUserId(userId);
    }
}
