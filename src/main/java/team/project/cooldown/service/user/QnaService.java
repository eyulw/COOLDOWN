package team.project.cooldown.service.user;

import team.project.cooldown.model.Qna;

public interface QnaService {

    boolean insertQnaWrite(Qna q);

    Object readBoard(Integer cpg);

    Object countBoard();

    Object readOneBoard(String bno);

    boolean saveQna(Qna q);

    Object readFindBoard(Integer cpg, String findtype, String findkey);

    Object countFindBoard(String findtype, String findkey);
}
