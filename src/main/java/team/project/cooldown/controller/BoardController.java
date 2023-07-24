package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.project.cooldown.model.Board;
import team.project.cooldown.service.board.BoardService;

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
    public String writeok(Board b) {
        logger.info("board/writeok 호출");
        String returnPage = "redirect:/board/fail";
        if(bsrv.saveBoard(b))
            returnPage = "redirect:/board/list/1";
        return returnPage;
    }

//    @PostMapping("/write")
//    public String getArticlesByCategory(@RequestParam(value = "category", required = false) String category, Model model) {
//        List<Article> filteredArticles;
//
//        if (category == null || category.isEmpty() || category.equals("All Categories")) {
//            // If no category selected or "All Categories" selected, show all articles
//            filteredArticles = articles;
//        } else {
//            // Filter articles by the selected category
//            filteredArticles = articles.stream()
//                    .filter(article -> article.getCategory().equals(category))
//                    .collect(Collectors.toList());
//        }
//
//        model.addAttribute("articles", filteredArticles);
//        model.addAttribute("categories", categories);
//        model.addAttribute("selectedCategory", category);
//
//        return "bulletin_board";
//    }

//    @PostMapping("/write")
//    public String writeok(Board b, MultipartFile attach) {
//        logger.info("board/writeok 호출!!");
//        String returnPage = "redirect:/board/fail";
//        // 작성한 게시글을 먼저 디비에 저장하고 글번호를 알아냄
//        int bno = bsrv.newBoard(b);
//        // 알아낸 글 번호를 이용해서 첨부파일 처리(DB 저장, 업로드)
//        if(!attach.isEmpty()) {  // 첨부파일이 존재한다면
//            bsrv.newBoardAttach(attach, bno);
//            returnPage = "redirect:/board/list/1";
//        }
//        return returnPage;
//    }


    // view 관련
    @GetMapping("/view/{board_id}")
    public String view(Model m, @PathVariable String board_id) {
        logger.info("board/view/board_id 호출!!");
        m.addAttribute("bd",bsrv.readOneBoard(board_id));
        return "board/view";
    }
}
