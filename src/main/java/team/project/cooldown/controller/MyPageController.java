package team.project.cooldown.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import team.project.cooldown.model.Qna;
import team.project.cooldown.model.User;
import team.project.cooldown.service.user.QnaService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.project.cooldown.service.user.UserService;
import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    final QnaService qsrv;
    final UserService usrv;

    Logger logger = LogManager.getLogger(MyPageController.class);

    @GetMapping("/order")
    public String shop() {
        logger.info("mypage/order 호출");

        return "mypage/order";
    }
    @GetMapping("/wishlist") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String wishlist() {
        logger.info("mypage/order 호출!!");

        return "mypage/wish_list"; // 얘가 파일명
    }
    @GetMapping("/cancel") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String cancel() {
        logger.info("mypage/cancel 호출!!");

        return "mypage/cancel"; // 얘가 파일명
    }
    @GetMapping("/qna") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String qna() {
        logger.info("mypage/qna 호출!!");

        return "mypage/qna"; // 얘가 파일명
    }
    @GetMapping("/modifyinfo/{u_id}") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String modifyinfo(Model m, @PathVariable String u_id) {
        logger.info("mypage/modifyinfo 호출!!");
        m.addAttribute("u", usrv.readMyinfo(u_id));

        return "mypage/modifyinfo"; // 얘가 파일명
    }
    @PostMapping("/modifyinfo/{u_id}") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String modifyinfook(@PathVariable String u_id,User u) {
        logger.info("mypage/modifyinfo 호출!!");

        String returnPage="redirect:/fail";
        u.setU_id(u_id);
        if(usrv.modifyMyInfo(u))
            returnPage="redirect:/";
        return returnPage;
    }
    @GetMapping("/deleteacct") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String deleteacct() {
        logger.info("mypage/deleteacct 호출!!");

        return "mypage/deleteacct"; // 얘가 파일명
    }
    @GetMapping("/deleteacctok") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String deleteacctok() {
        logger.info("mypage/deleteacctok 호출!!");

        return "mypage/deleteacctok"; // 얘가 파일명
    }
    @PostMapping("/deleteacctok") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String deleteacctok(User u, HttpSession sess) {
        logger.info("mypage/deleteacctok 호출!!");
        String returnPage = "redirect:/fail";
        u = usrv.readOneUser(u);
        if (u != null && usrv.removeOneUser(u)) {
            sess.invalidate();
            returnPage = "redirect:/";
        }
        return returnPage;
    }
    @GetMapping("/insertQnaWrite")        //작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
    public String insertQnaWrite(Qna q) {
        logger.info("mypage/qnawrite 호출 ~");
        String returnPage = "redirect:/mypage/fail";

        if (qsrv.insertQnaWrite(q))
            returnPage = "redirect:/mypage/qna/1";

        return returnPage;    //게시글 리스트로 이동
    }
};