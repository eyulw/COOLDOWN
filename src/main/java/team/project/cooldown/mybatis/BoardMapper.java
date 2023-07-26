package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;

import java.util.List;

@Mapper
public interface BoardMapper {

    int insertBoard(Board b);

    int updateViewBoard(String board_id);

    Board selectOneBoard(String board_id);

    List<Board> selectBoard(int stnum);

    int selectCountBoard();

    int insertBoardAttach(BoardAttach ba);

    int lastBoardBoard_id();
/*
    int insertBoardAttach(BoardAttach ba);

    int insertNewBoard(Board b);
*/
}
