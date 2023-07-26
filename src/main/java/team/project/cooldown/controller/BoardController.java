package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.model.Board;
import team.project.cooldown.service.board.BoardService;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final BoardService bsrv;
    Logger logger = LogManager.getLogger(BoardController.class);

    // list 관련
    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {
        logger.info("board/list 호출");
        m.addAttribute("bds",bsrv.readBoard(cpg));
        m.addAttribute("cpg",cpg);
        m.addAttribute("cntpg",bsrv.countBoard());
        m.addAttribute("stpg",((cpg-1)/10)*10+1);
        //만일, 현재페이지(cpg)가 총 페이지 수(cntpg)보다 크면 cpg를 1페이지로 강제 이동
        if(cpg > (int)m.getAttribute("cntpg")) {
            return "redirect:/board/list/1";
        }
        return "board/list";
    }


    // write 관련
    @GetMapping("/write")
    public String write() {
        logger.info("board/write 호출");
        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board b, List<MultipartFile> attachs) {
        logger.info("board/writeok 호출");
        String returnPage = "redirect:/board/fail";
        int board_id  = bsrv.newBoard(b);
        if(!attachs.isEmpty()) {
            bsrv.newBoardAttach(attachs, board_id);
            returnPage = "redirect:/board/list/1";
        }
        return returnPage;
    }


    // view 관련
    @GetMapping("/view/{board_id}")
    public String view(Model m, @PathVariable String board_id) {
        logger.info("board/view/board_id 호출!!");
        m.addAttribute("bd",bsrv.readOneBoard(board_id));
        return "board/view";
    }

    // fidn category 관련
    /*@GetMapping("/find/{findkey}/{cpg}")
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findkey,){
        logger.info("board/find 호출!!");
        m.addAttribute("bds",bsrv.readFindBoard(cpg, findkey));
        m.addAttribute("cpg",cpg);
        m.addAttribute("cntpg",bsrv.countFindBoard(findkey));
        m.addAttribute("stpg",((cpg-1)/5)*5+1);
        m.addAttribute("fkey", findkey);
        //만일, 현재페이지(cpg)가 총 페이지 수(cntpg)보다 크면 cpg를 1페이지로 강제 이동
        if(cpg > (int)m.getAttribute("cntpg")) {
            return "redirect:/board/list/1";
        }
        return "board/list";
    }*/
}
