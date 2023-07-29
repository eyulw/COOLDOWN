package team.project.cooldown.service.user;

import team.project.cooldown.model.User;

public interface UserService {
    boolean saveUser(User u);

    User readOneUser(User u);

    User readMyInfo(String u_id);

    boolean modifyMyInfo(User u);

    int checkuid(String uid);
}
