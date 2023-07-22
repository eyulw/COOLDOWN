package team.project.cooldown.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.admin.QnaDAO;
import team.project.cooldown.dao.admin.UserDAO;
import team.project.cooldown.model.Qna;

import java.util.List;

@Service("a_qsrv")
public class QnaServiceImpl implements QnaService{
    @Autowired
    private QnaDAO a_qdao;
    @Override
    public List<Qna> readQna() {
        return a_qdao.selectQna();
    }
}
