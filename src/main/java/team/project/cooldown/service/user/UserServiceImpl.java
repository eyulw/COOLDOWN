package team.project.cooldown.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.user.UserDAO;
import team.project.cooldown.model.User;

@Service("usrv")
public class UserServiceImpl implements UserService {
    @Autowired private UserDAO udao;

    @Override
    public boolean saveUser(User u) {
        return (udao.insertUser(u)>0 )? true : false;
    }

    @Override
    public User readOneUser(User u) {
        return udao.selectOneUser(u);
    }
}
