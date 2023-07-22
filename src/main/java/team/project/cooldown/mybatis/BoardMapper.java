package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.Board;

@Mapper
public interface BoardMapper {

    int insertBoard(Board b);

    int lastBoardBno();
}
