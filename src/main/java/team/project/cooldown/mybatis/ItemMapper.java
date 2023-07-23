package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.ItemCombine;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemCombine> selectItemCombine(String sort);
    List<ItemCombine> selectItemCombine_d(String sort);
    List<ItemCombine> selectItemCombine_c(String sort);
    List<ItemCombine> selectItemCombine_h(String sort);
    List<ItemCombine> selectItemCombine_b(String sort);
    List<ItemCombine> selectItemCombine_r(String sort);


}
