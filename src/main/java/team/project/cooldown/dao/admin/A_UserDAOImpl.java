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



}
