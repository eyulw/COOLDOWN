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

    List<Board> readHotTopic();

    List<Board> readNewBoard();

    boolean removeOneBoard(String board_id);

    int getCountBoard();

/*
    boolean newBoardAttach(MultipartFile attach, int board_id);

    int newBoard(Board b);
*/
}
