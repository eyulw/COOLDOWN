package team.project.cooldown.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.project.cooldown.dao.user.QnaDAO;
import team.project.cooldown.model.Qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("qsrv")
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    final QnaDAO qdao;
    @Override
    public boolean insertQnaWrite(Qna q) {
        boolean isSaved = false;
        if (qdao.insertQnaWrite(q) > 0) isSaved = true;
        return isSaved;
    }

    @Override
    public Object readBoard(Integer cpg) {
        return null;
    }

    @Override
    public Object countBoard() {
        return null;
    }


    public List<Qna> readQna(Integer cpg) {
        int stnum = (cpg - 1) * 25;
        return qdao.selectQna(stnum);
    }


    public Qna readOneQna(String bno) {

        return qdao.selectOneQna(bno);
    }

    @Override
    public boolean saveQna(Qna q) {
        return (qdao.insertQna(q)>0) ? true : false;
    }

    @Override
    public Object readFindBoard(Integer cpg, String findtype, String findkey) {
        return null;
    }

    @Override
    public Object countFindBoard(String findtype, String findkey) {
        return null;
    }

    @Override
    public List<Qna> readQna(String u_id) {

        return qdao.selectMyQna(u_id);
        }

    public int countQna() {

        return qdao.selectCountQna();
    }



    public List<Qna> readFindQna(Integer cpg, String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", ftype);
        params.put("findkey", fkey);
        params.put("stnum", (cpg - 1) * 25);

        return qdao.selectFindQna(params);
    }


    public int countFindQna(String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", ftype);
        params.put("findkey", fkey);
        return qdao.countFindQna(params);
    }
}

//    @Override
//    public boolean insertQnaWrite(Qna q) {
//        boolean isSaved = false;
//        if (qdao.insertQnaWrite(q) > 0) isSaved = true;
//        return isSaved;
//    }
//
//    @Override
//    public Object readBoard(Integer cpg) {
//        return null;
//    }
//
//    @Override
//    public Object countBoard() {
//        return null;
//    }
//
//    public List<Qna> readQna(Integer cpg) {
//        int stnum = (cpg - 1) * 25;
//        return qdao.selectQna(stnum);
//        }
//
//    public Qna readOneQna(String qna_id) {
//
//        return qdao.selectOneQna(qna_id);
//        }
//
//    @Override
//    public boolean saveQna(Qna q) {
//
//        return (qdao.insertQna(q)>0) ? true : false;
//    }
//
//    @Override
//    public Object readFindBoard(Integer cpg, String findtype, String findkey) {
//
//        return null;
//    }
//
//    @Override
//    public Object countFindBoard(String findtype, String findkey) {
//
//        return null;
//    }
//
//
//    @Override
//    public List<Qna> readQna(String u_id) {
//
//        return qdao.selectMyQna(u_id);
//    }
////
////    @Override
////    public List<Qna> readQnaListSortedByDate() {
////        return qnaMapper.selectQnaListSortedByDate();
////    }
//
//
//    public int countQna() {
//
//        return qdao.selectCountQna();
//        }
//
//        public List<Qna> readFindQna(Integer cpg, String ftype, String fkey) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("findtype", ftype);
//        params.put("findkey", fkey);
//        params.put("stnum", (cpg - 1) * 25);
//
//        return qdao.selectFindQna(params);
//        }
//
//        public int countFindQna(String ftype, String fkey) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("findtype", ftype);
//        params.put("findkey", fkey);
//        return qdao.countFindQna(params);
//        }
//}
