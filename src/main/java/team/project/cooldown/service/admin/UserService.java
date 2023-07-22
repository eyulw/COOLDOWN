package team.project.cooldown.service.admin;

import team.project.cooldown.model.User;

import java.util.List;

public interface UserService {
    List<User> readUser();
    User readOneUser(String u_id);
}
