package team.project.cooldown.dao.likes;


import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface LikesDAO {

    void insertLikes(String u_id, Integer item_id);





    void deleteLikes(String u_id, Integer item_id);




    int selectLikesCount(String u_id, Integer item_id);

    int LikesItemCount(Integer item_id);

}
