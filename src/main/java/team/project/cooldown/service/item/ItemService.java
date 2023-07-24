package team.project.cooldown.service.item;


import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface ItemService {

    List<ItemCombine> readItemCombine(String sort);
    List<ItemCombine> readItemCombine_d(String sort);
    List<ItemCombine> readItemCombine_c(String sort);
    List<ItemCombine> readItemCombine_h(String sort);
    List<ItemCombine> readItemCombine_b(String sort);
    List<ItemCombine> readItemCombine_r(String sort);


}
