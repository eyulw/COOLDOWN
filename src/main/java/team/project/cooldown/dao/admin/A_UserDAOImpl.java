package team.project.cooldown.dao.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.User;
import team.project.cooldown.mybatis.UserMapper;

import java.util.List;

@Repository("a_udao")
@RequiredArgsConstructor
public class A_UserDAOImpl implements A_UserDAO {

    final UserMapper userMapper;

    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }

    @Override
    public List<User> selectUserRole(String role) {
        return userMapper.selectUserRole(role);
    }

    @Override
    public int selectCountUser() {
        return userMapper.selectCountUser();
    }

    @Override
    public int getCountUPages() {
        return userMapper.getCountUPages();
    }

    @Override
    public int getCountRUPages(String role) {
        return userMapper.getCountRUPages(role);
    }


}
