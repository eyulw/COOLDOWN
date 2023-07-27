package team.project.cooldown.dao.item;


import team.project.cooldown.model.*;

import java.util.List;

public interface ItemDAO {

    List<ItemCombine> selectItemCombine(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_d(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_c(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_h(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_b(String sort, Integer idx);
    List<ItemCombine> selectItemCombine_r(String sort, Integer idx);

    void insertCart(String u_id, Integer item_id, Integer count);

    List<CartCombine> selectCart(String u_id);
    int insertItem(Item i);

    int insertItemAttach(ItemAttach ia);
    List<Item> selectItemAtt();

    int deleteItem(String item_id);

    int selectCountCart(String u_id, Integer item_id);

    void updateCountCart(String u_id, Integer item_id, Integer count);

    void updateCountCart_c(String cart_id, String count);

    void deleteCart(String cart_id);
}
