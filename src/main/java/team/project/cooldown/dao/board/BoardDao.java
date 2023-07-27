package team.project.cooldown.dao.board;

import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;
import team.project.cooldown.model.BoardComments;

import java.util.List;
import java.util.Map;

public interface BoardDao {

    int insertBoard(Board b);

    Board selectOneBoard(String board_id);

    List<Board> selectBoard(int stnum);

    int selectCountBoard();

    int insertBoardAttach(BoardAttach ba);

    List<Board> selectFindBoard(Map<String, Object> params);

    int countFindBoard(Map<String, Object> params);

    int insertnobdattach(int board_id);

    List<Board> selectFindcBoard(String category);

    List<BoardComments> selectBoardComment(String board_id);

    int insertBoardComment(BoardComments bc);

    int insertBoardReply(BoardComments bc);


/*
    int insertBoardAttach(BoardAttach ba);

    int insertNewBoard(Board b);
*/
}
