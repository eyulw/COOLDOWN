package team.project.cooldown.dao.admin;

import team.project.cooldown.model.ItemQna;
import team.project.cooldown.model.Qna;

import java.util.List;

public interface A_QnaDAO {
    List<Qna> selectQna();

    Qna selectOneQna(String qna_id);

    int updateAdminReply(String qid,String answer);

    List<ItemQna> selectItemQna();

    ItemQna selectOneItemQna(String itemqna_id);

    int updateAdminIReply(String itemqna_id, String answer);
}
