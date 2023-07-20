package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectUser();
}
