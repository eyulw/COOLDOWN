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
    public User selectMyInfo(String u_id) {
        return userMapper.selectMyInfo(u_id);
    }

    @Override
    public int updateMyInfo(User u) {
        return userMapper.updateMyInfo(u);
    }

    @Override
    public int selectOneUserid(String uid) {
        return userMapper.selectOneUserid(uid);
    }
//
//    회원 탈퇴
//    @Override
//    public void memberDelete(User u) throws Exception {
//        // MemberVO에 담긴 값들을 보내줍니다.
//        // 그럼 xml에서 memberMapper.memberDelete에 보시면
//        //  #{userId}, #{userPass}에 파라미터값이 매칭이 되겠지요.
//        user.delete("userMapper.userDelete", u);
//
//    }
}


