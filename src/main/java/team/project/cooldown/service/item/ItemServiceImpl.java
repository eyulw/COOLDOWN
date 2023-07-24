package team.project.cooldown.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.item.ItemDAO;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

@Service("isrv")
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    final ItemDAO idao;
    @Override
    public List<ItemCombine> readItemCombine(String sort) {
        return idao.selectItemCombine(sort);
    }

    @Override
    public List<ItemCombine> readItemCombine_d(String sort) {
        return idao.selectItemCombine_d(sort);
    }

    @Override
    public List<ItemCombine> readItemCombine_c(String sort) {
        return idao.selectItemCombine_c(sort);
    }

    @Override
    public List<ItemCombine> readItemCombine_h(String sort) {
        return idao.selectItemCombine_h(sort);
    }

    @Override
    public List<ItemCombine> readItemCombine_b(String sort) {
        return idao.selectItemCombine_b(sort);
    }

    @Override
    public List<ItemCombine> readItemCombine_r(String sort) {
        return idao.selectItemCombine_r(sort);
    }


}
