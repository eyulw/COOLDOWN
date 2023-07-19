package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    Logger logger = LogManager.getLogger(AdminController.class);
    @GetMapping("/")
    public String index(){
        logger.info("admin/member 호출");
        return "admin/index";
    }
    @GetMapping("/member")
    public String member(){
        logger.info("admin/member 호출");
        return "admin/member";
    }

    @GetMapping("/board")
    public String board(){
        logger.info("admin/board 호출");
        return "admin/board";
    }

}
