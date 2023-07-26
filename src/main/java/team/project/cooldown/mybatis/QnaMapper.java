package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.Qna;

import java.util.List;

@Mapper
public interface QnaMapper {
    List<Qna> selectQna();

    Qna selectOneQna(String qna_id);

    int updateAdminReply(String qid,String answer);

    int insertQnaWrite(Qna q);
}
