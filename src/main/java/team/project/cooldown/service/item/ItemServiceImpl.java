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
    public List<ItemCombine> readItemCombine() {
        return idao.selectItemCombine();
    }

    @Override
    public List<ItemCombine> readItemCombine_d() {
        return idao.selectItemCombine_d();
    }

    @Override
    public List<ItemCombine> readItemCombine_c() {
        return idao.selectItemCombine_c();
    }

    @Override
    public List<ItemCombine> readItemCombine_h() {
        return idao.selectItemCombine_h();
    }

    @Override
    public List<ItemCombine> readItemCombine_b() {
        return idao.selectItemCombine_b();
    }

    @Override
    public List<ItemCombine> readItemCombine_r() {
        return idao.selectItemCombine_r();
    }


}
