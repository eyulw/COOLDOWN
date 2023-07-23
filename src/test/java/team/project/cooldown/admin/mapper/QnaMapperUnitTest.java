package team.project.cooldown.admin.mapper;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;
import team.project.cooldown.mybatis.QnaMapper;



import static org.junit.jupiter.api.Assertions.assertEquals;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QnaMapperUnitTest {

    @Autowired
    private QnaMapper qnaMapper;

    @Test
    @DisplayName("QnaMapper updateReply Test")
    @Transactional
    void lastIdPds() {
        String qid="1";
        String answer="들어가니";
        int result = qnaMapper.updateAdminReply(qid,answer);
        System.out.println(result);
        assertEquals(result,1);
    }

}
