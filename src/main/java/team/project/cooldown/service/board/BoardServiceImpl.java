package team.project.cooldown.service.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.board.BoardDao;
import team.project.cooldown.model.Board;

import java.util.List;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    final BoardDao bdao;

    @Override
    public boolean saveBoard(Board b) {
        boolean isSaved = false;
        if(bdao.insertBoard(b) > 0) isSaved = true;
        return isSaved;
    }

    @Override
    public Board readOneBoard(String board_id) {
        return bdao.selectOneBoard(board_id);
    }

    @Override
    public List<Board> readBoard(Integer cpg) {
        int stnum = (cpg - 1) * 5;
        return bdao.selectBoard(stnum);
    }

    @Override
    public int countBoard() {
        return bdao.selectCountBoard();
    }
}
