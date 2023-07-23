package team.project.cooldown.dao.item;


import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface ItemDAO {

    List<ItemCombine> selectItemCombine(String sort);
    List<ItemCombine> selectItemCombine_d(String sort);
    List<ItemCombine> selectItemCombine_c(String sort);
    List<ItemCombine> selectItemCombine_h(String sort);
    List<ItemCombine> selectItemCombine_b(String sort);
    List<ItemCombine> selectItemCombine_r(String sort);

}
