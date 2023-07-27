package team.project.cooldown.dao.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;
import team.project.cooldown.mybatis.BoardMapper;

import java.util.List;


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

/*
    @Override
    public int insertBoardAttach(BoardAttach ba) {
        return boardMapper.insertBoardAttach(ba);
    }

    @Override
    public int insertNewBoard(Board b) {
        int cnt = boardMapper.insertNewBoard(b);
        if(cnt > 0) cnt = boardMapper.lastBoardBoard_id();
        return cnt;
    }
*/

}
