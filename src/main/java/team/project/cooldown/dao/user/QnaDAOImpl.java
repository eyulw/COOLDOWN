package team.project.cooldown.dao.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.cooldown.model.Qna;
import team.project.cooldown.mybatis.QnaMapper;

import java.util.List;
import java.util.Map;

@Repository("qdao")
@RequiredArgsConstructor
public class QnaDAOImpl implements QnaDAO {

    final QnaMapper qnaMapper;

    @Override
    public int insertQnaWrite(Qna q) {
        return qnaMapper.insertQnaWrite(q);
    }

    @Override
    public List<Qna> selectQna(int stnum) {
        return null;
    }

    @Override
    public Qna selectOneQna(String qna_id) {
        return qnaMapper.selectOneQna(qna_id);
    }

    @Override
    public int selectCountQna() {
        return 0;
    }

    @Override
    public List<Qna> selectFindQna(Map<String, Object> params) {
        return null;
    }

    @Override
    public int countFindQna(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int insertQna(Qna q) {
        return qnaMapper.insertQnaWrite(q) ;
    }

    @Override
   public List<Qna> selectMyQna(String u_id) {
       return qnaMapper.selectMyQna(u_id);

   }

//    @Override
//    public List<Qna> selectQnaListSortedByDate() {
//        return qnaMapper.selectQnaListSortedByDate();
//    }

    public int selectCountBoard() {
        return 0;
    }
}
