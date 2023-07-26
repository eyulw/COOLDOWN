package team.project.cooldown.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.dao.item.ItemDAO;
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


}
