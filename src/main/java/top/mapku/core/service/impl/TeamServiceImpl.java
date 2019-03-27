package top.mapku.core.service.impl;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import top.mapku.core.entity.Team;
import top.mapku.core.mapper.TeamMapper;
import top.mapku.core.service.TeamService;

import javax.annotation.Resource;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Component
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper teamMapper;

    @Override
    @Cacheable(value = "teamOfUser", key = "#userId")
    public Team getTeamByUserId(String userId) {
        return teamMapper.getTeamByUserId(userId);
    }

    @Override
    @CachePut(value = "teamOfUser", key = "#userId")
    public Team changeTeam(String userId, String teamId) {
        return teamMapper.getTeamById(teamId);
    }
}
