package top.mapku.core.service;

import top.mapku.core.entity.Team;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public interface TeamService {
    Team getTeamByUserId(String userId);

    Team changeTeam(String userId, String teamId);
}
