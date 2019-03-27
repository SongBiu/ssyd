package top.mapku.core.service;

import org.springframework.cache.annotation.Cacheable;
import top.mapku.core.dto.OpenIdDto;
import top.mapku.core.dto.UserDto;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public interface UserService {

    UserDto getUserById(String id);

    List<UserDto> getUsersByTeamId(Integer teamId);


    UserDto login(String jsonCode, String name, String avatarUrl, HttpSession session);
}
