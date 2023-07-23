package team.project.cooldown.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    Logger logger = LogManager.getLogger(IndexController.class);
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
