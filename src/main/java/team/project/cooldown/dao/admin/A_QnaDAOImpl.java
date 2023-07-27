package team.project.cooldown.dao.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.ItemQna;
import team.project.cooldown.model.Qna;
import team.project.cooldown.mybatis.QnaMapper;

import java.util.List;

@Repository("a_qdao")
@RequiredArgsConstructor
public class A_QnaDAOImpl implements A_QnaDAO {
    final QnaMapper qnaMapper;
    @Override
    public List<Qna> selectQna() {
        return qnaMapper.selectQna();
    }

    @Override
    public Qna selectOneQna(String qna_id) {
        return qnaMapper.selectOneQna(qna_id);
    }

    @Override
    public int updateAdminReply(String qid,String answer) {
        return qnaMapper.updateAdminReply(qid,answer);
    }

    @Override
    public List<ItemQna> selectItemQna() {
        return qnaMapper.selectItemQna();
    }

    @Override
    public ItemQna selectOneItemQna(String itemqna_id) {
        return qnaMapper.selectOneItemQna(itemqna_id);
    }

    @Override
    public int updateAdminIReply(String itemqna_id, String answer) {
        return qnaMapper.updateAdminIReply(itemqna_id,answer);
    }
}
