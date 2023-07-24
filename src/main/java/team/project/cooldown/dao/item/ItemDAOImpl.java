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


}
