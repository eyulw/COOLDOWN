package team.project.cooldown.dao.admin;

import team.project.cooldown.model.User;

import java.util.List;

public interface UserDAO {
    List<User> selectUser();
}
