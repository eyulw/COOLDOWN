package team.project.cooldown.service.board;

import team.project.cooldown.model.Board;

import java.util.List;

public interface BoardService {

    boolean saveBoard(Board b);

    Board readOneBoard(String board_id);

    List<Board> readBoard(Integer cpg);

    int countBoard();
}
