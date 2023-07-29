package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.project.cooldown.model.User;
import team.project.cooldown.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class JoinController {

    Logger logger = LogManager.getLogger(JoinController.class);
    final UserService usrv;

    @GetMapping("/join/checkuid/{uid}")
    @ResponseBody
    public void checkuid(@PathVariable String uid, HttpServletResponse res) throws IOException {
        res.setContentType("application/json; charset=utf-8");
        res.getWriter().print(usrv.checkuid(uid));
    }

    @PostMapping("/join")
    public String jojnok(User u){
        logger.info("joinform_modal joinok호출");
        String returnPage = "redirect:/fail";
        if(usrv.saveUser(u))
            returnPage="redirect:/";
        return returnPage;
    }

    @PostMapping("/login") // localhost:8080/agree URl이 호출되면 불리는 메서드
    public String loginok(User u, HttpSession sess){
        logger.info("login_modal loginok 호출");
        String returnPage="redirect:/fail";
        u = usrv.readOneUser(u);
        if(u!=null){
            sess.setAttribute("user",u);
            sess.setAttribute("u_id",u.getU_id());
            returnPage="redirect:/";
        }
        return returnPage;
    }

    @GetMapping("/logout")
    public String logout(HttpSession sess){
        logger.info("logout 호출");
        sess.invalidate();
        return "redirect:/";
    }
}
