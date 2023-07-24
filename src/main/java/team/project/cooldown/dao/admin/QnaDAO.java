package team.project.cooldown.dao.admin;

import team.project.cooldown.model.Qna;

import java.util.List;

public interface QnaDAO {
    List<Qna> selectQna();

    Qna selectOneQna(String qna_id);

    int updateAdminReply(String qid,String answer);
}
