package team.project.cooldown.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.admin.A_UserDAO;
import team.project.cooldown.model.User;

import java.util.List;

@Service("a_usrv")
public class A_UserServiceImpl implements A_UserService {

    @Autowired private A_UserDAO a_udao;
    @Override
    public List<User> readUser() {
        return a_udao.selectUser();
    }


}
