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

    @Override
    public boolean removeOneUser(User u) {
        return udao.deleteOneuser(u)>0? true: false;
    }

    @Override
    public User readMyinfo(String u_id) {
        return udao.selectMyInfo(u_id);
    }

    @Override
    public boolean modifyMyInfo(User u) {
        return udao.updateMyInfo(u)>0? true: false;
    }

    @Override
    public int checkuid(String uid) {
        return udao.selectOneUserid(uid);
    }
}
