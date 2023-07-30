package team.project.cooldown.service.likes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.project.cooldown.dao.likes.LikesDAO;

@Service("lsrv")
@RequiredArgsConstructor
@Transactional
public class LikesServiceImpl implements LikesService{

    final LikesDAO ldao;


    /*u_id 세션아이디값으로 item_id 파라미터idx값으로*/
    @Override
    public void allLikes(String u_id, Integer item_id) {
        if(ldao.selectLikesCount(u_id,item_id) == 0){
            ldao.insertLikes(u_id, item_id);

        }else if(ldao.selectLikesCount(u_id,item_id) > 0){
            ldao.deleteLikes(u_id, item_id);

        }
    }
    @Override
    public int currentLikesCount(Integer item_id) {
        return ldao.LikesItemCount(item_id);
    }

}
