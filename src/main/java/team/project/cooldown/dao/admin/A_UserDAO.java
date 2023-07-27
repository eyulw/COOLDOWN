package team.project.cooldown.dao.admin;

import team.project.cooldown.model.User;

import java.util.List;

public interface A_UserDAO {
    List<User> selectUser();

    List<User> selectUserRole(String role);

    int selectCountUser();
}
