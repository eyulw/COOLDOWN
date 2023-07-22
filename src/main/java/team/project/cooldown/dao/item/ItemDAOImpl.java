package team.project.cooldown.dao.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.ItemCombine;
import team.project.cooldown.mybatis.ItemMapper;


import java.util.List;

@Repository("idao")
@RequiredArgsConstructor
public class ItemDAOImpl implements ItemDAO{

    final ItemMapper itemMapper;


    @Override
    public List<ItemCombine> selectItemCombine() {
        return itemMapper.selectItemCombine();
    }

    @Override
    public List<ItemCombine> selectItemCombine_d() {
        return itemMapper.selectItemCombine_d();
    }

    @Override
    public List<ItemCombine> selectItemCombine_c() {
        return itemMapper.selectItemCombine_c();
    }

    @Override
    public List<ItemCombine> selectItemCombine_h() {
        return itemMapper.selectItemCombine_h();
    }

    @Override
    public List<ItemCombine> selectItemCombine_b() {
        return itemMapper.selectItemCombine_b();
    }

    @Override
    public List<ItemCombine> selectItemCombine_r() {
        return itemMapper.selectItemCombine_r();
    }


}
