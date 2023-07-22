package team.project.cooldown.dao.item;


import team.project.cooldown.model.ItemCombine;

import java.util.List;

public interface ItemDAO {

    List<ItemCombine> selectItemCombine();
    List<ItemCombine> selectItemCombine_d();
    List<ItemCombine> selectItemCombine_c();
    List<ItemCombine> selectItemCombine_h();
    List<ItemCombine> selectItemCombine_b();
    List<ItemCombine> selectItemCombine_r();

}
