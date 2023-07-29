package team.project.cooldown.dao.user;

import team.project.cooldown.model.User;

public interface UserDAO {
    int insertUser(User u);

    User selectOneUser(User u);


    User selectMyInfo(String u_id);

    int updateMyInfo(User u);

    int selectOneUserid(String uid);
}
