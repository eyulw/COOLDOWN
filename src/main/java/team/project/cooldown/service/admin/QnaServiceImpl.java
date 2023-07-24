package team.project.cooldown.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.admin.A_QnaDAO;
import team.project.cooldown.model.Qna;

import java.util.List;

@Service("a_qsrv")
public class QnaServiceImpl implements QnaService{
    @Autowired
    private A_QnaDAO a_qdao;
    @Override
    public List<Qna> readQna() {
        return a_qdao.selectQna();
    }

    @Override
    public Qna readOneQna(String qna_id) {
        return a_qdao.selectOneQna(qna_id);
    }

    @Override
    public boolean updateAdminReply(String qid,String answer) {
        return (a_qdao.updateAdminReply(qid,answer) > 0) ? true : false;
    }
}
