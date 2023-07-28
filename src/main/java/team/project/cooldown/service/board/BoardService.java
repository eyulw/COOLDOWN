package team.project.cooldown.service.board;

import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardComments;

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

    List<Board> readFindBoard(Integer cpg, String fkey);

    int countFindBoard(String fkey);

    boolean noBoardAttach(int board_id);

    List<Board> readFindcBoard(String category);

    List<BoardComments> readBoardComment(String board_id);

    boolean newBoardComment(BoardComments bc);

    boolean newBoardReply(BoardComments bc);


}
