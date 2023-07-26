package team.project.cooldown.service.board;

import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.model.Board;

import java.util.List;

public interface BoardService {

    //boolean saveBoard(Board b);
    int newBoard(Board b);

    Board readOneBoard(String board_id);

    List<Board> readBoard(Integer cpg);

    int countBoard();

    boolean newBoardAttach(List<MultipartFile> attachs, int board_id);

/*
    boolean newBoardAttach(MultipartFile attach, int board_id);

    int newBoard(Board b);
*/
}
