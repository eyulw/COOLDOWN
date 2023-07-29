package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUser();
    User selectOneUser(User u);

    int insertUser(User u);

    List<User> selectUserRole(String role);

    int selectCountUser();

    int getCountUPages();

    int getCountRUPages(String role);

    int deleteOneUser(User u);

    User selectMyInfo(String u_id);

    int updateMyInfo(User u);

    int selectOneUserid(String uid);
}
