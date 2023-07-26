package team.project.cooldown.dao.item;


import team.project.cooldown.model.Cart;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface ItemDAO {

    List<ItemCombine> selectItemCombine(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_d(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_c(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_h(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_b(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_r(String sort, Integer idx);

    void insertCart(String u_id, Integer item_id, Integer count);

    Cart selectCart(String uId);
}
