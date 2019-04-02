package top.mapku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mapku.core.entity.Team;
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
    public Team getTeamByUserId(@CookieValue("id") String userId) {
        return teamService.getTeamByUserId(userId);
    }
}
