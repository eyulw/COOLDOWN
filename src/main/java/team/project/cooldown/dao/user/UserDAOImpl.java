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

    @Override
    public int deleteOneuser(User u) {
        return userMapper.deleteOneUser(u);
    }


    @Override
    public int updateMyInfo(User u) {
        return userMapper.updateMyInfo(u);
    }

    @Override
    public User selectMyInfo(String u_id) {
        return userMapper.selectMyInfo(u_id);
    }


    @Override
    public int selectOneUserid(String uid) {
        return userMapper.selectOneUserid(uid);
    }
}

