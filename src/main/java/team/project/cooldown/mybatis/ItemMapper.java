package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.*;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemCombine> selectItemCombine(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_d(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_c(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_h(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_b(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_r(String sort,Integer idx);


    void insertCart(String u_id, Integer item_id, Integer count);

    int selectCountCart(String u_id, Integer item_id);

    void updateCountCart(String u_id, Integer item_id, Integer count);
    List<CartCombine> selectCart(String uId);


    int insertItem(Item i);

    int lastItemId();

    int insertItemAttach(ItemAttach ia);

    List<Item> selectItemAtt();/*전체 Item 가져오기*/
    List<Item> selectItemAtt(String category);/*category별 Item 가져오기*/

    int deleteItem(String item_id);


    void updateCountCart_c(String cart_id, String count);

    void deleteCart(String cart_id);

    Item selectOneItem(String item_id);

    int updateOneItem(Item i);

    int updateItemAttach(ItemAttach ia);

    List<Item> selectItemAttCt(String category);
}
