package team.project.cooldown.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")

public class MemberJoinController {

    Logger logger = LogManager.getLogger(MemberJoinController.class);

    @RequestMapping("/agree") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String findAgree(){
        logger.info("join/login 호출!!");

        return "/join/agree"; // 얘가 파일명
    }

    @RequestMapping("/joinForm") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String findJoinForm(){
        logger.info("join/joinform 호출!!!!");

        return "join/joinForm"; // 얘가 파일명
    }

    @RequestMapping("/join") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String JoinForm(){
        logger.info("join/join 호출!!!!");

        return "index"; // 얘가 파일명
    }

    @RequestMapping ("/login") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String loinForm(){
        logger.info("join/login 호출~~");

        return "join/join"; // 얘가 파일명
    }

    @RequestMapping ("/index") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String loginCancel(){
        logger.info("join/login 호출~~");

        return "index"; // 얘가 파일명
    }

    @RequestMapping ("/find") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String idpwdFind(){
        logger.info("join/idpwd_find 호출~~");

        return "join/idpwd_find"; // 얘가 파일명
    }

    @RequestMapping ("/pwdfind") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String pwdFind(){
        logger.info("join/pwdfind 찾으셈요");

        return "join/pwd_find"; // 얘가 파일명
    }

    @RequestMapping("/join/checkuid/{userId}")
    public String checkUserId(@PathVariable String userId) {
        /**
         * 아이디 중복 검사
         * Service -> Dao(Mapper) -> DB에서
         * SELECT COUNT(*) FROM user WHERE user_id = userId // userid == 123
         */

        return null;
    }

    @RequestMapping("/memberJoin") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String memberJoin(){
        logger.info("join/join 호출!!!!");

        /**
         * 회원가입 -> 비밀번호/비밀번호 확인이 맞는지
         * 이메일 형식 맞는지
         *
         *  등등 유효성 검증 완료되면 DB에 저장
         *  위 검증에 실패하면 DB 저장 X
         */

        return "index"; // 얘가 파일명
    }
}
