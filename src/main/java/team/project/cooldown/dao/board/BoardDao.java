package team.project.cooldown.dao.board;

import team.project.cooldown.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardDao {

    int insertBoard(Board b);

    Board selectOneBoard(String board_id);

    List<Board> selectBoard(int stnum);

    int selectCountBoard();
}
