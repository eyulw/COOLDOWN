package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemCombine> selectItemCombine(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_d(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_c(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_h(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_b(String sort,Integer idx);
    List<ItemCombine> selectItemCombine_r(String sort,Integer idx);


}
