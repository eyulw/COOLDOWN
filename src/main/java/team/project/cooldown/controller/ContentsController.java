package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentsController {
    Logger logger = LogManager.getLogger(ContentsController.class);

    @GetMapping("/list")
    public String list() {
        logger.info("contents/list 호출");
        return "/contents/list";
    }
}
