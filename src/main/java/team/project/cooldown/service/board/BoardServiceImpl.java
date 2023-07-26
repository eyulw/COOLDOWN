package team.project.cooldown.service.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.dao.board.BoardDao;
import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;
import team.project.cooldown.utils.BoardUtils;

import java.util.List;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    final BoardDao bdao;
    final BoardUtils boardUtils;

    /*@Override
    public boolean saveBoard(Board b){
        boolean isSaved = false;
        if(bdao.insertBoard(b) > 0) isSaved = true;
        return isSaved;
    }*/
    @Override
    public int newBoard(Board b) {
        return bdao.insertBoard(b);
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

    @Override
    public boolean newBoardAttach(List<MultipartFile> attachs, int board_id) {
        BoardAttach ba = boardUtils.processUpload(attachs);
        boardUtils.makeThumbnail(ba);
        ba.setBoard_id(board_id+"");
        return (bdao.insertBoardAttach(ba) > 0) ? true : false;
    }

/*
    @Override
    public boolean newBoardAttach(MultipartFile attach, int board_id) {
        BoardAttach ba = boardUtils.processUpload(attach);
        ba.setBoard_id(board_id + "");
        int bacnt = bdao.insertBoardAttach(ba);
        return (bacnt > 0) ? true : false;
    }

    @Override
    public int newBoard(Board b) {
        return bdao.insertNewBoard(b);
    }
*/

}
