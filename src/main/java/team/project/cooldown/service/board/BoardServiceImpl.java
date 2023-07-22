package team.project.cooldown.service.board;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.board.BoardDao;
import team.project.cooldown.model.Board;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    final BoardDao bdao;

    @Override
    public int newBoard(Board b) {
        return bdao.insertBoard(b);
    }
}
