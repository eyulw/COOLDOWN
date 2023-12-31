package team.project.cooldown.dao.user;

import team.project.cooldown.model.Qna;

import java.util.List;
import java.util.Map;

public interface QnaDAO {


   int insertQnaWrite(Qna q);

   List<Qna> selectQna(int stnum);

   Qna selectOneQna(String qna_id);

   int selectCountQna();

   List<Qna> selectFindQna(Map<String, Object> params);

   int countFindQna(Map<String, Object> params);

   int insertQna(Qna q);

   List<Qna> selectMyQna(String u_id);
}

////
//   List<Qna> selectQnaListSortedByDate();
//}
