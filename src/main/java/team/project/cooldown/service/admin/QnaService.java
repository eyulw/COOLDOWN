package team.project.cooldown.service.admin;

import team.project.cooldown.model.Qna;

import java.util.List;

public interface QnaService {
    List<Qna> readQna();

    Qna readOneQna(String qna_id);

    boolean updateAdminReply(String qid,String answer);
}
