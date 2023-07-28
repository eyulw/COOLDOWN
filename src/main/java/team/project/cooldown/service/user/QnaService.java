package team.project.cooldown.service.user;

import team.project.cooldown.model.Qna;

import java.util.List;

public interface QnaService {

    boolean insertQnaWrite(Qna q);

    Object readBoard(Integer cpg);

    Object countBoard();

     Qna readOneQna(String qna_id);

    boolean saveQna(Qna q);

    Object readFindBoard(Integer cpg, String findtype, String findkey);

    Object countFindBoard(String findtype, String findkey);

    List<Qna> readQna(String u_id);
//
//    List<Qna> readQnaListSortedByDate(String u_id);

}
