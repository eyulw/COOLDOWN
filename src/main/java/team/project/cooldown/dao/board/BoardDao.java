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

    List<Board> selectFindcBoard(Map<String, Object> params);

    int countFindBoard(Map<String, Object> params);

    int insertBoardAttach(BoardAttach ba);

    int insertnobdattach(int board_id);

    List<BoardComments> selectBoardComment(String board_id);

    int insertBoardComment(BoardComments bc);

    int insertBoardReply(BoardComments bc);

    List<Board> selectHotTopic();

    List<Board> selectNewBoard();

    int deleteOneBoard(String board_id);

    int getCountBoard();

    int updateboard(Board b);

    int updateBoardAttach(BoardAttach ba);

    Board selectModifyBoard(String board_id);

    int removeOneBoard(String board_id);

}
