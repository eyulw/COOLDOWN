package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.Board;

import java.util.List;

@Mapper
public interface BoardMapper {

    int insertBoard(Board b);

    int lastBoardBno();

    int updateViewBoard(String board_id);

    Board selectOneBoard(String board_id);

    List<Board> selectBoard(int stnum);

    int selectCountBoard();
}
