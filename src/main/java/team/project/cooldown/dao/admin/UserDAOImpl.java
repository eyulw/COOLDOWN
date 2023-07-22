package team.project.cooldown.dao.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.User;
import team.project.cooldown.mybatis.UserMapper;

import java.util.List;

@Repository("a_udao")
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    final UserMapper userMapper;

    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }

    @Override
    public User selectOneUser(String u_id) {
        return userMapper.selectOneUser(u_id);
    }
}
