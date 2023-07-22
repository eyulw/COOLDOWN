package team.project.cooldown.dao.board;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.Board;
import team.project.cooldown.mybatis.BoardMapper;


@Repository("bdao")
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao{
    final BoardMapper boardMapper;

    @Override
    public int insertBoard(Board b) {
        int cnt = boardMapper.insertBoard(b);
        if(cnt > 0) cnt = boardMapper.lastBoardBno();
        return cnt;
    }
}
