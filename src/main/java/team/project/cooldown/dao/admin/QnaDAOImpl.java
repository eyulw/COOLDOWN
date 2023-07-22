package team.project.cooldown.dao.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.Qna;
import team.project.cooldown.mybatis.QnaMapper;
import team.project.cooldown.mybatis.UserMapper;

import java.util.List;

@Repository("a_qdao")
@RequiredArgsConstructor
public class QnaDAOImpl implements QnaDAO{
    final QnaMapper qnaMapper;
    @Override
    public List<Qna> selectQna() {
        return qnaMapper.selectQna();
    }
}
