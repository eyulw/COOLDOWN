package team.project.cooldown.dao.likes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.mybatis.LikesMapper;

@Repository("ldao")
@RequiredArgsConstructor
public class LikesDAOImpl implements LikesDAO{
    final LikesMapper likesMapper;
    @Override
    public void insertLikes(String u_id, Integer item_id) {
        likesMapper.insertLikes(u_id, item_id);
    }



    @Override
    public void deleteLikes(String u_id, Integer item_id) {
        likesMapper.deleteLikes(u_id,item_id);
    }



    @Override
    public int selectLikesCount(String u_id, Integer item_id) {
        return likesMapper.selectLikesCount(u_id,item_id);
    }

    @Override
    public int LikesItemCount(Integer item_id) {
        return likesMapper.LikesItemCount(item_id);
    }
}
