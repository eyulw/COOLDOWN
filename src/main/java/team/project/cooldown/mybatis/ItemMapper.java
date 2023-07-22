package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemCombine> selectItemCombine();
    List<ItemCombine> selectItemCombine_d();
    List<ItemCombine> selectItemCombine_c();
    List<ItemCombine> selectItemCombine_h();
    List<ItemCombine> selectItemCombine_b();
    List<ItemCombine> selectItemCombine_r();


}
