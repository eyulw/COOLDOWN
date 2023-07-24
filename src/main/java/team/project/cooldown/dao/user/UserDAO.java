package team.project.cooldown.dao.user;

import team.project.cooldown.model.User;

public interface UserDAO {
    int insertUser(User u);

    User selectOneUser(User u);
}
