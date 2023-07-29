package team.project.cooldown.service.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.dao.board.BoardDao;
import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;
import team.project.cooldown.model.BoardComments;
import team.project.cooldown.utils.BoardUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    final BoardDao bdao;
    final BoardUtils boardUtils;
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
    public List<Board> readFindcBoard(String category, Integer cpg) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("stnum", (cpg - 1) * 5);
        return bdao.selectFindcBoard(params);
    }

    @Override
    public int countFindBoard(String category) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        return bdao.countFindBoard(params);
    }

    @Override
    public boolean newBoardAttach(List<MultipartFile> attachs, int board_id) {
        BoardAttach ba = boardUtils.processUpload(attachs);
        boardUtils.makeThumbnail(ba);
        ba.setBoard_id(board_id+"");
        return (bdao.insertBoardAttach(ba) > 0) ? true : false;
    }

    @Override
    public List<Board> readHotTopic() {
        return bdao.selectHotTopic();
    }

    @Override
    public List<Board> readNewBoard() {
        return bdao.selectNewBoard();
    }

    @Override
    public boolean removeOneBoard(String board_id) {
        return (bdao.deleteOneBoard(board_id) > 0) ? true : false;
    }

    @Override
    public int getCountBoard() {
        return bdao.getCountBoard();
    }

    @Override
    public boolean noBoardAttach(int board_id) {
        return bdao.insertnobdattach(board_id) > 0 ? true : false;
    }

    @Override
    public List<BoardComments> readBoardComment(String board_id) {
        return bdao.selectBoardComment(board_id);
    }

    @Override
    public boolean newBoardComment(BoardComments bc) {
        return (bdao.insertBoardComment(bc) > 0) ? true : false;
    }

    @Override
    public boolean newBoardReply(BoardComments bc) {
        return (bdao.insertBoardReply(bc) > 0) ? true : false;
    }

    @Override
    public boolean modifyboard(Board b) {
        return bdao.updateboard(b) > 0 ? true : false;
    }

    @Override
    public boolean modifyboardattach(Board b, List<MultipartFile> attachs) {
        boolean isUpdated = false;
        BoardAttach ba = boardUtils.processUpload(attachs);
        boardUtils.makeThumbnail(ba);
        ba.setBoard_id(b.getBoard_id()+"");
        if((bdao.updateboard(b) > 0) && (bdao.updateBoardAttach(ba) > 0)) isUpdated = true;
        return isUpdated;
    }

    @Override
    public Board readModifyBoard(String board_id) {
        return bdao.selectModifyBoard(board_id);
    }

    @Override
    public boolean deleteBoard(String board_id) {
        return (bdao.removeOneBoard(board_id) > 0) ? true : false;
    }

}
