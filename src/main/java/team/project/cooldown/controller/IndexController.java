package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.project.cooldown.service.board.BoardService;

@Controller
@RequiredArgsConstructor
public class IndexController {
    Logger logger = LogManager.getLogger(IndexController.class);
    final BoardService bsrv;
    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("hbds",bsrv.readHotTopic());
        m.addAttribute("nbds",bsrv.readNewBoard());
        return "index";
    }

}
