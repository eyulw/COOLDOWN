package team.project.cooldown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AcctController {

    @Controller
    public class AccountController {

        // 회원 탈퇴 페이지 보여주기
        @GetMapping("/deletacct")
        public String showDeleteAccountPage() {
            return "deletacct";
        }

        // 회원 탈퇴 처리
        @PostMapping("/deleteAccount")
        public String deleteAccount(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
            // 여기서는 사용자 이름과 비밀번호를 확인하는 로직을 추가하고, 탈퇴 처리를 수행합니다.
            // 이 예시에서는 단순히 콘솔에 출력하는 로직만 추가합니다.
            System.out.println("사용자 이름: " + username);
            System.out.println("비밀번호: " + password);

            // TODO: 실제 회원 정보를 데이터베이스에서 삭제하는 로직을 구현해야 합니다.

            return "redirect:/deletacct"; // 탈퇴 후에는 다시 회원 탈퇴 페이지로 리다이렉트합니다.
        }
    }
}
