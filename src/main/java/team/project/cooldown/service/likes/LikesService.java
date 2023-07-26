package team.project.cooldown.service.likes;


import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface LikesService {

    void allLikes(String u_id, Integer item_id);

    int currentLikesCount(Integer item_id);





}
