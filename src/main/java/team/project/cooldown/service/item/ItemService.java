package team.project.cooldown.service.item;


import team.project.cooldown.dao.likes.LikesDAO;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface ItemService {


    List<ItemCombine> readItemCombine(String sort, Integer idx);
    List<ItemCombine> readItemCombine_d(String sort,Integer idx);
    List<ItemCombine> readItemCombine_c(String sort,Integer idx);
    List<ItemCombine> readItemCombine_h(String sort,Integer idx);
    List<ItemCombine> readItemCombine_b(String sort,Integer idx);
    List<ItemCombine> readItemCombine_r(String sort,Integer idx);


}
