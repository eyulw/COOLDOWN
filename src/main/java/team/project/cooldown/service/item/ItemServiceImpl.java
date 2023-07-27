package team.project.cooldown.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.dao.item.ItemDAO;
import team.project.cooldown.model.Cart;
import team.project.cooldown.model.Item;
import team.project.cooldown.model.ItemAttach;
import team.project.cooldown.model.ItemCombine;
import team.project.cooldown.utils.ItemUtils;

import java.util.List;

@Service("isrv")
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    final ItemDAO idao;
    final ItemUtils itemUtils;
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

    @Override
    public int newItem(Item i) {
        return idao.insertItem(i);
    }

    @Override
    public boolean newItemAttach(MultipartFile attach, int itemId) {
        ItemAttach ia = itemUtils.itemImgUpload(attach);
        ia.setItem_id(itemId+"");
        int iacnt=idao.insertItemAttach(ia);
        return iacnt>0?true:false;
    }

    @Override
    public List<Item> readItemAtt() {
        return idao.selectItemAtt();
    }

    @Override
    public boolean removeItem(String item_id) {
        return idao.deleteItem(item_id)>0?true:false;
    }

    @Override
    public Item readOneItem(String item_id) {
        return idao.selectOneItem(item_id);
    }

    @Override
    public boolean modifyOneItem(Item i) {
        return idao.updateOneItem(i)>0? true:false;
    }

    @Override
    public boolean modifyIOneItem(Item i, MultipartFile attach) {
        boolean isUpdated=false;
        ItemAttach ia = itemUtils.itemImgUpload(attach);
        ia.setItem_id(i.getItem_id());
        if((idao.updateOneItem(i)>0) && (idao.updateItemAttach(ia)>0)) isUpdated=true;
        return isUpdated;
    }

    @Override
    public List<Item> readItemAttCt(String category) {
        return idao.selectItemAttCt(category);
    }


}
