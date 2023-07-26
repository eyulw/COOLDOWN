package team.project.cooldown.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.item.ItemDAO;
import team.project.cooldown.model.Cart;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

@Service("isrv")
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    final ItemDAO idao;
    @Override
    public List<ItemCombine> readItemCombine(String sort, Integer idx) {
        return idao.selectItemCombine(sort,idx);
    }

    @Override
    public List<ItemCombine> readItemCombine_d(String sort,Integer idx) {
        return idao.selectItemCombine_d(sort,idx);
    }

    @Override
    public List<ItemCombine> readItemCombine_c(String sort,Integer idx) {
        return idao.selectItemCombine_c(sort,idx);
    }

    @Override
    public List<ItemCombine> readItemCombine_h(String sort,Integer idx) {
        return idao.selectItemCombine_h(sort,idx);
    }

    @Override
    public List<ItemCombine> readItemCombine_b(String sort,Integer idx) {
        return idao.selectItemCombine_b(sort,idx);
    }

    @Override
    public List<ItemCombine> readItemCombine_r(String sort,Integer idx) {
        return idao.selectItemCombine_r(sort,idx);
    }

    @Override
    public void addCart(String u_id, Integer item_id, Integer count) {
        idao.insertCart(u_id,item_id,count);
    }

    @Override
    public Cart chooseCart(String uId) {
        return idao.selectCart(uId);
    }


}
