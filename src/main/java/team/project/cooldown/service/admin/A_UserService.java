package team.project.cooldown.service.admin;

import team.project.cooldown.model.User;

import java.util.List;

public interface A_UserService {
    List<User> readUser();

    List<User> readUserRole(String role);

    int countUser();

    int getCountUPages();

    int getCountRUPages(String role);
}
