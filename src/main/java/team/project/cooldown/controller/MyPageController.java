package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequiredArgsConstructor

public class MyPageController {

    Logger logger = LogManager.getLogger(MyPageController.class);

    @RequestMapping("/shop")
    public String shop(){
        logger.info("mypage/order 호출");

        return "mypage/order/";
    }

    @RequestMapping("/wishlist") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String wishlist(){
        logger.info("mypage/order 호출!!");

        return "mypage/wish_list"; // 얘가 파일명
    }
    @RequestMapping("/cancel") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String cancel(){
        logger.info("mypage/cancel 호출!!");

        return "mypage/cancel"; // 얘가 파일명
    }
    @RequestMapping("/qna") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String qna(){
        logger.info("mypage/qna 호출!!");

        return "mypage/qna"; // 얘가 파일명
    }
    @RequestMapping("/qnawrite") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String qnawrite(){
        logger.info("mypage/qnawrite 호출!!");

        return "mypage/qnawrite"; // 얘가 파일명
    }
    @RequestMapping("/modifyinfo") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String modifyinfo(){
        logger.info("mypage/modifyinfo 호출!!");

        return "mypage/modifyinfo"; // 얘가 파일명
    }
    @RequestMapping("/deleteacct") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String deleteacct(){
        logger.info("mypage/deleteacct 호출!!");

        return "mypage/deleteacct"; // 얘가 파일명
    }
}