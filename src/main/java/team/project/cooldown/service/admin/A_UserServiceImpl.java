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

    @Override
    public List<User> readUserRole(String role) {
        return a_udao.selectUserRole(role);
    }

    @Override
    public int countUser() {
        return a_udao.selectCountUser();
    }

    @Override
    public int getCountUPages() {
        return a_udao.getCountUPages();
    }

    @Override
    public int getCountRUPages(String role) {
        return a_udao.getCountRUPages(role);
    }


}
