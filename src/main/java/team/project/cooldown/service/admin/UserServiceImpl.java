package team.project.cooldown.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.admin.UserDAO;
import team.project.cooldown.model.User;

import java.util.List;

@Service("a_usrv")
public class UserServiceImpl implements UserService{

    @Autowired private UserDAO a_udao;
    @Override
    public List<User> readUser() {
        return a_udao.selectUser();
    }

    @Override
    public User readOneUser(String u_id) {
        return a_udao.selectOneUser(u_id);
    }
}
