package team.project.cooldown.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.admin.A_QnaDAO;
import team.project.cooldown.model.ItemQna;
import team.project.cooldown.model.Qna;

import java.util.List;

@Service("a_qsrv")
public class A_QnaServiceImpl implements A_QnaService {
    @Autowired
    private A_QnaDAO a_qdao;
    @Override
    public List<Qna> readQna(Integer cpg) {
        int stnum=15*(cpg-1);
        return a_qdao.selectQna(stnum);
    }

    @Override
    public Qna readOneQna(String qna_id) {
        return a_qdao.selectOneQna(qna_id);
    }

    @Override
    public boolean updateAdminReply(String qid,String answer) {
        return (a_qdao.updateAdminReply(qid,answer) > 0) ? true : false;
    }

    @Override
    public List<ItemQna> readItemQna(Integer cpg) {
        int stnum=15*(cpg-1);
        return a_qdao.selectItemQna(stnum);
    }

    @Override
    public ItemQna readOneItemQna(String itemqna_id) {
        return a_qdao.selectOneItemQna(itemqna_id);
    }

    @Override
    public boolean updateAdminIReply(String itemqna_id, String answer) {
        return (a_qdao.updateAdminIReply(itemqna_id,answer) > 0) ? true : false;
    }

    @Override
    public int getCountPages() {
        return a_qdao.getCountPages();
    }

    @Override
    public int getCountIQPages() {
        return a_qdao.getCountIQPages();
    }
}
