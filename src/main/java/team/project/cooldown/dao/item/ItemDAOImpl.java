package team.project.cooldown.dao.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.*;
import team.project.cooldown.mybatis.ItemMapper;


import java.util.List;

@Repository("idao")
@RequiredArgsConstructor
public class ItemDAOImpl implements ItemDAO{

    final ItemMapper itemMapper;


    @Override
    public List<ItemCombine> selectItemCombine(String sort, Integer idx) {
        return itemMapper.selectItemCombine(sort,idx);
    }

    @Override
    public List<ItemCombine> selectItemCombine_d(String sort, Integer idx) {
        return itemMapper.selectItemCombine_d(sort,idx);
    }

    @Override
    public List<ItemCombine> selectItemCombine_c(String sort, Integer idx) {
        return itemMapper.selectItemCombine_c(sort,idx);
    }

    @Override
    public List<ItemCombine> selectItemCombine_h(String sort, Integer idx) {
        return itemMapper.selectItemCombine_h(sort,idx);
    }

    @Override
    public List<ItemCombine> selectItemCombine_b(String sort, Integer idx) {
        return itemMapper.selectItemCombine_b(sort,idx);
    }

    @Override
    public List<ItemCombine> selectItemCombine_r(String sort, Integer idx) {
        return itemMapper.selectItemCombine_r(sort,idx);
    }

    @Override
    public void insertCart(String u_id, Integer item_id, Integer count) {
        itemMapper.insertCart(u_id,item_id,count);
    }

    @Override
    public List<CartCombine> selectCart(String u_id) {
        return itemMapper.selectCart(u_id);
    }

    @Override
    public int insertItem(Item i) {
        int iId=itemMapper.insertItem(i);
        if(iId>0)
            iId=itemMapper.lastItemId();
        return iId;
    }

    @Override
    public int insertItemAttach(ItemAttach ia) {
        return itemMapper.insertItemAttach(ia);
    }

    @Override
    public List<Item> selectItemAtt() {
        return itemMapper.selectItemAtt();
    }

    @Override
    public int deleteItem(String item_id) {
        return itemMapper.deleteItem(item_id);
    }

    @Override
    public int selectCountCart(String u_id, Integer item_id) {
        return itemMapper.selectCountCart(u_id,item_id);
    }

    @Override
    public void updateCountCart(String u_id, Integer item_id, Integer count) {
        itemMapper.updateCountCart(u_id,item_id,count);
    }

    @Override
    public void updateCountCart_c(String cart_id, String count) {
        itemMapper.updateCountCart_c(cart_id,count);
    }

    @Override
    public void deleteCart(String cart_id) {
        itemMapper.deleteCart(cart_id);
    }

    @Override
    public Item selectOneItem(String item_id) {
        return itemMapper.selectOneItem(item_id);
    }

    @Override
    public int updateOneItem(Item i) {
        return itemMapper.updateOneItem(i);
    }

    @Override
    public int updateItemAttach(ItemAttach ia) {
        return itemMapper.updateItemAttach(ia);
    }

    @Override
    public List<Item> selectItemAttCt(String category) {
        return itemMapper.selectItemAttCt(category);
    }

    @Override
    public List<CartCombine> wishList(String u_id) {
        return itemMapper.wishList(u_id);
    }

    @Override
    public void buyCart(List<Item> cart_id) {
        itemMapper.buyCart(cart_id);
    }

    @Override
    public List<User> customer_info(String uId) {
        return itemMapper.customer_info(uId);
    }


}
