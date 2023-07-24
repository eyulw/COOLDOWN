package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.project.cooldown.service.admin.QnaService;
import team.project.cooldown.service.admin.UserService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    Logger logger = LogManager.getLogger(AdminController.class);
    final UserService a_usrv;
    final QnaService a_qsrv;

    @GetMapping("/")
    public String index(){
        logger.info("admin/ 호출");
        return "admin/index";
    }
    @GetMapping("/user")
    public String member(Model m){
        logger.info("admin/user 호출");
        m.addAttribute("users",a_usrv.readUser());
        return "admin/user";
    }

    @GetMapping("/board")
    public String board(){
        logger.info("admin/board 호출");
        return "admin/board";
    }

    @GetMapping("/item")
    public String item(){
        logger.info("admin/item 호출");
        return "admin/item";
    }

    @GetMapping("/qna")
    public String qna(Model m){
        logger.info("admin/qna 호출");
        m.addAttribute("qnas",a_qsrv.readQna());
        return "admin/qna";
    }

    @GetMapping("/itemqna")
    public String itemqna(){
        logger.info("admin/itemqna 호출");
        return "admin/itemqna";
    }
    @GetMapping("/qna/{qna_id}")
    public String qnareply(Model m,@PathVariable String qna_id){
        logger.info("admin/qnareply 호출");
        /*q_no 글 불러오기*/
        m.addAttribute("q",a_qsrv.readOneQna(qna_id));
        return "admin/qnareply";
    }
    @PostMapping("/qna/{qid}")
    public String qnareplyok(@PathVariable String qid,String answer){
        logger.info("admin/qnareplyok 호출");
        String returnPage="redirect:/admin/fail";
        if(a_qsrv.updateAdminReply(qid,answer))
            returnPage="redirect:/admin/qna";
        /*qid 글에 관리자 답변 넣어서 update*/
        return returnPage;
    }


}
