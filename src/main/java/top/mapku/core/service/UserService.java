package top.mapku.core.service;

import top.mapku.core.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public interface UserService {

    User getUserById(String id);

    List<User> getUsersByTeamId(Integer teamId);


    User login(String jsonCode, String name, String avatarUrl, HttpSession session);
}
