package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
@RequiredArgsConstructor

public class MyPageController {

    Logger logger = LogManager.getLogger(MyPageController.class);
    @RequestMapping("/shop")
    public String shop(){
        logger.info("mypage/shop_mypage 호출");

        return "mypage/shop_mypage";
    }
}