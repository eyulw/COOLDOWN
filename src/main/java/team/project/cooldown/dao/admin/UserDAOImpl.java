package team.project.cooldown.dao.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.User;

import java.util.List;

@Repository("a_udao")
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> selectUser() {
        return null;
    }
}
