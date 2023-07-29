package team.project.cooldown.dao.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;
import team.project.cooldown.model.BoardComments;
import team.project.cooldown.mybatis.BoardMapper;

import java.util.List;
import java.util.Map;


@Repository("bdao")
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {
    final BoardMapper boardMapper;

    @Override
    public int insertBoard(Board b) {
        int cnt = boardMapper.insertBoard(b);
        if(cnt>0) cnt = boardMapper.lastBoardBoard_id();
        return cnt;
    }

    @Override
    public Board selectOneBoard(String board_id) {
        boardMapper.updateViewBoard(board_id);
        return boardMapper.selectOneBoard(board_id);
    }

    @Override
    public List<Board> selectBoard(int stnum) {
        return boardMapper.selectBoard(stnum);
    }

    @Override
    public int selectCountBoard() {
        return boardMapper.selectCountBoard();
    }

    @Override
    public int insertBoardAttach(BoardAttach ba) {
        return boardMapper.insertBoardAttach(ba);
    }

    @Override
    public List<Board> selectHotTopic() {
        return boardMapper.selectHotTopic();
    }

    @Override
    public List<Board> selectNewBoard() {
        return boardMapper.selectNewBoard();
    }

    @Override
    public int deleteOneBoard(String board_id) {
        return boardMapper.deleteOneBoard(board_id);
    }

    @Override
    public int getCountBoard() {
        return boardMapper.getCountBoard();
    }

    @Override
    public List<Board> selectFindBoard(Map<String, Object> params) {
        return boardMapper.selectFindBoard(params);

    }

    @Override
    public int countFindBoard(Map<String, Object> params) {
        return boardMapper.countFindBoard(params);
    }

    @Override
    public int insertnobdattach(int board_id) {
        return boardMapper.insertnobdattach(board_id);
    }

    @Override
    public List<Board> selectFindcBoard(String category) {
        return boardMapper.selectFindcBoard(category);
    }

    @Override
    public List<BoardComments> selectBoardComment(String board_id) {
        return boardMapper.selectBoardComment(board_id);
    }

    @Override
    public int insertBoardComment(BoardComments bc) {
        bc.setRef(boardMapper.lastBCReplyid()+"");
        System.out.println(bc.getRef());
        return boardMapper.insertBoardComment(bc);
    }

    @Override
    public int insertBoardReply(BoardComments bc) {
        return boardMapper.insertBoardReply(bc);
    }

}
