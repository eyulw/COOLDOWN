package team.project.cooldown.service.user;

import team.project.cooldown.model.User;

public interface UserService {
    boolean saveUser(User u);

    User readOneUser(User u);

    boolean removeOneUser(User u);

    User readMyinfo(String u_id);

    boolean modifyMyInfo(User u);
}
