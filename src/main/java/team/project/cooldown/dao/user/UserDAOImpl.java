package team.project.cooldown.dao.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.User;
import team.project.cooldown.mybatis.UserMapper;

@Repository("udao")
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {
    final UserMapper userMapper;
    @Override
    public int insertUser(User u) {
        return userMapper.insertUser(u);
    }

    @Override
    public User selectOneUser(User u) {
        return userMapper.selectOneUser(u);
    }
}
