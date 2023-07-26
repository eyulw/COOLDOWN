package team.project.cooldown.dao.board;

import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;

import java.util.List;

public interface BoardDao {

    int insertBoard(Board b);

    Board selectOneBoard(String board_id);

    List<Board> selectBoard(int stnum);

    int selectCountBoard();

    int insertBoardAttach(BoardAttach ba);

/*
    int insertBoardAttach(BoardAttach ba);

    int insertNewBoard(Board b);
*/
}
