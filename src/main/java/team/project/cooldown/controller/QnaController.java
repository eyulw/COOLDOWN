package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.project.cooldown.model.Qna;
import team.project.cooldown.service.user.QnaService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
@ControllerAdvice

public class QnaController {

    final QnaService qsrv;

    Logger logger = LogManager.getLogger(QnaController.class);

    @GetMapping("/mypage/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {
        logger.info("mypage/list 호출!!");

        m.addAttribute("qds", qsrv.readBoard(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", qsrv.countBoard());
        m.addAttribute("stpg", ((cpg-1) / 10 ) * 10 +1);

        // 만일, 현재페이지가 총페이지수 보다 크다면
        // 1페이지로 강제 이동
        if (cpg > (int)m.getAttribute("cntpg"))
            return "redirect:/mypage/qna";

        return "mypage/qna";
    }
    @GetMapping("/qnaview/{qna_id}")
    public String view(Model m, @PathVariable String qna_id) {
        logger.info("mypage/view 호출!!");

        m.addAttribute("qd", qsrv.readOneQna(qna_id));

        return "mypage/qnaview";
    }

    @GetMapping("/qnawrite")
    public String write() {
        logger.info("mypage/qnawrite 호출!!");

        return "mypage/qnawrite";
    }


    @PostMapping("/qnawrite")
    public String writeok(Qna q) {
        logger.info("mypage/writeok 호출!!");
        String returnPage = "redirect:/mypage/fail";

        if (qsrv.saveQna(q))
            returnPage = "redirect:/mypage/qnaview";
        //

        return returnPage;
    }

//    @GetMapping("/find/{findtype}/{findkey}/{cpg}")
//    public String find(Model m, @PathVariable Integer cpg,
//                       @PathVariable String findtype, @PathVariable String findkey){
//        logger.info("mypage/qna 호출!!");
//
//        m.addAttribute("qds", qsrv.readFindBoard(cpg, findtype, findkey));
//        m.addAttribute("cpg", cpg);
//        m.addAttribute("cntpg", qsrv.countFindBoard(findtype, findkey));
//        m.addAttribute("stpg", ((cpg-1) / 10 ) * 10 +1);
//        m.addAttribute("fkey", findkey);
//        m.addAttribute("ftype", findtype);
//
//        // 만일, 현재페이지가 총페이지수 보다 크다면
//        // 1페이지로 강제 이동
//        if (cpg > (int)m.getAttribute("cntpg"))
//            return "redirect:/mypage/qna/1";
//
//        return "mypage/qna";
//    }
    @GetMapping("/qna/{u_id}")
    public String qna(Model m,@PathVariable String u_id){
        logger.info("/mypage/qna/list 호출");

        m.addAttribute("qnas",qsrv.readQna(u_id));

        return "mypage/qna";
    }
}