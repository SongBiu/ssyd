package top.mapku.core.service;

import top.mapku.core.dto.TeamDto;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public interface TeamService {
    TeamDto getTeamByUserId(String userId);

    TeamDto changeTeam(String userId, String teamId);
}
