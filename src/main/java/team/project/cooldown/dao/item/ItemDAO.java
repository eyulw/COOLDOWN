package team.project.cooldown.dao.item;


import team.project.cooldown.model.Item;
import team.project.cooldown.model.ItemAttach;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface ItemDAO {

    List<ItemCombine> selectItemCombine(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_d(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_c(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_h(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_b(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_r(String sort, Integer idx);

    int insertItem(Item i);

    int insertItemAttach(ItemAttach ia);
}
