package team.project.cooldown.dao.board;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.Board;
import team.project.cooldown.mybatis.BoardMapper;

import java.util.List;


@Repository("bdao")
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao{
    final BoardMapper boardMapper;

    @Override
    public int insertBoard(Board b) {
        return boardMapper.insertBoard(b);
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

}
