package team.project.cooldown.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team.project.cooldown.model.Qna;
import team.project.cooldown.model.User;
import team.project.cooldown.service.user.QnaService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import team.project.cooldown.service.user.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    final QnaService qsrv;
    final UserService usrv;

    Logger logger = LogManager.getLogger(MyPageController.class);

    @RequestMapping("/order")
    public String shop() {
        logger.info("mypage/order 호출");

        return "mypage/order";
    }

    @RequestMapping("/wishlist") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String wishlist() {
        logger.info("mypage/order 호출!!");

        return "mypage/wish_list"; // 얘가 파일명
    }

    @RequestMapping("/cancel") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String cancel() {
        logger.info("mypage/cancel 호출!!");

        return "mypage/cancel"; // 얘가 파일명
    }

    @RequestMapping("/qna") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String qna() {
        logger.info("mypage/qna 호출!!");

        return "mypage/qna"; // 얘가 파일명
    }

    //    @RequestMapping("/qnawrite") // localhost:8080/agree URl이 호출되면 불리는 메서드
//    public String qnawrite(){
//        logger.info("mypage/qnawrite 호출!!");
//
//        return "mypage/qnawrite"; // 얘가 파일명
//    }
    @GetMapping("/modifyinfo/{u_id}") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String modifyinfo(Model m,@PathVariable String u_id) {
        logger.info("mypage/modifyinfo 호출!!");
        m.addAttribute("u",usrv.readMyInfo(u_id));
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

    @RequestMapping("/deleteacct") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String deleteacct() {
        logger.info("mypage/deleteacct 호출!!");

        return "mypage/deleteacct"; // 얘가 파일명
    }

//    @GetMapping ("/qnawrite")		//게시글 작성 화면 호출, 단순 호출값, 실제 대상체의 이름과는 상관 없음
//    public String qnaWrite() {
//        logger.info("mypage/qnawrite 호출");
//
//        return "mypage/qnawrite";
//    }

    @PostMapping("/insertQnaWrite")        //작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
    public String insertQnaWrite(Qna q) {
        logger.info("mypage/qnawrite 호출 ~");
        String returnPage = "redirect:/mypage/fail";

        if (qsrv.insertQnaWrite(q))
            returnPage = "redirect:/mypage/qna/1";

        return returnPage;    //게시글 리스트로 이동
    }
}

//    // 회원 탈퇴 get
//    @RequestMapping(value="/userDelete", method = RequestMethod.GET)
//    public String userDelete() throws Exception{
//        return "mypage/userdelete";
//    }
//
//    // 회원 탈퇴 post
//    @RequestMapping(value="/userDelete", method = RequestMethod.POST)
//    public String userDelete(User u, HttpSession session, RedirectAttributes rttr) throws Exception{
//
//        // 세션에 있는 member를 가져와 member변수에 넣어줍니다.
//        User user = (User) session.getAttribute("User");
//        // 세션에있는 비밀번호
//        String sessionPass = user.getPassword();
//        // vo로 들어오는 비밀번호
//        String uPass = u.getPassword();
//
//        if(!(sessionPass.equals(uPass))) {
//            rttr.addFlashAttribute("msg", false);
//            return "redirect:/member/memberDeleteView";
//        }
//        Service.userDelete(u);
//        session.invalidate();
//        return "redirect:/";
//    }
//}
//    @RequestMapping("/qnawrite")
//    public String qnawrite() {
//        logger.info("mypage/qnawrite 호출!!");
//
//        return "mypage/qnawrite";
//    }
//
//    @RequestMapping("/qnalist")
//    public String qnalist() {
//        logger.info("mypage/qnalist 호출!!");
//
//        return "mypage/qnalist";
//    }
//}