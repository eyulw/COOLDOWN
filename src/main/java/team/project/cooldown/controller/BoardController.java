package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.model.Board;
import team.project.cooldown.service.board.BoardService;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final BoardService bsrv;
    Logger logger = LogManager.getLogger(BoardController.class);

    // list 관련
    @GetMapping("/list")
    public String list() {
        logger.info("board/list 호출");
        return "board/list";
    }

    // write 관련
    @GetMapping("/write")
    public String write() {
        logger.info("board/write 호출");
        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board b, MultipartFile attach) {
        logger.info("board/writeok 호출!!");
        String returnPage = "redirect:/board/fail";
        // 작성한 게시글을 먼저 디비에 저장하고 글번호를 알아냄
        int bno = bsrv.newBoard(b);
        // 알아낸 글 번호를 이용해서 첨부파일 처리(DB 저장, 업로드)
//        if(!attach.isEmpty()) {  // 첨부파일이 존재한다면
//            bsrv.newBoardAttach(attach, bno);
//            returnPage = "redirect:/board/list/1";
//        }
        return returnPage;
    }

    // view 관련
    @GetMapping("/view")
    public String view() {
        logger.info("board/view 호출");
        return "board/view";
    }
}
