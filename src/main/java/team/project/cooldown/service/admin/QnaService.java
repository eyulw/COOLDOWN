package team.project.cooldown.service.admin;

import team.project.cooldown.model.ItemQna;
import team.project.cooldown.model.Qna;

import java.util.List;

public interface QnaService {
    List<Qna> readQna();

    Qna readOneQna(String qna_id);

    boolean updateAdminReply(String qid,String answer);

    List<ItemQna> readItemQna();

    ItemQna readOneItemQna(String itemqna_id);

    boolean updateAdminIReply(String itemqna_id, String answer);
}
