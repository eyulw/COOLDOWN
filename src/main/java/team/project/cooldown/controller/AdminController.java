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
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.model.Item;
import team.project.cooldown.service.admin.A_QnaService;
import team.project.cooldown.service.admin.A_UserService;
import team.project.cooldown.service.board.BoardService;
import team.project.cooldown.service.item.ItemService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    Logger logger = LogManager.getLogger(AdminController.class);
    final A_UserService a_usrv;
    final A_QnaService a_qsrv;
    final BoardService bsrv;
    final ItemService isrv;

    @GetMapping("/")
    public String index(){
        logger.info("admin/ 호출");
        return "admin/index";
    }
    @GetMapping("/user/list/{cpg}")
    public String member(Model m,@PathVariable Integer cpg){
        logger.info("admin/user 호출");
        m.addAttribute("users",a_usrv.readUser());
        m.addAttribute("usercnt",a_usrv.countUser());
        m.addAttribute("stpg",5*((cpg-1)/5)+1);
        m.addAttribute("cntpg",a_usrv.getCountUPages());
        m.addAttribute("cpg",cpg);
        return "admin/user";
    }
    @GetMapping("/role/{role}/{cpg}")
    public String member(Model m,@PathVariable String role,@PathVariable Integer cpg){
        logger.info("admin/role/~ 호출");
        m.addAttribute("users",a_usrv.readUserRole(role));
        m.addAttribute("usercnt",a_usrv.countUser());
        m.addAttribute("stpg",5*((cpg-1)/5)+1);
        m.addAttribute("cntpg",a_usrv.getCountRUPages(role));
        return "admin/user";
    }

    @GetMapping("/board/{cpg}")
    public String board(Model m,@PathVariable Integer cpg){
        logger.info("admin/board 호출");
        m.addAttribute("cntbd",bsrv.getCountBoard());
        m.addAttribute("bds",bsrv.readBoard(cpg));
        m.addAttribute("stpg",10*((cpg-1)/10)+1);
        m.addAttribute("cntpg",bsrv.countBoard());
        m.addAttribute("cpg",cpg);
        if(cpg > (int)m.getAttribute("cntpg"))
            return "redirect:/admin/board/1";
        return "admin/board";
    }

    @GetMapping("/boardDelete/{board_id}")
    public String boardDelete(@PathVariable String board_id){
        logger.info("admin/boardDelete 호출");
        String returnPage="redirect:/fail";
        if(bsrv.removeOneBoard(board_id))
            returnPage="redirect:/admin/board/1";
        return returnPage;
    }



    @GetMapping("/item")
    public String item(Model m){
        logger.info("admin/item 호출");
        m.addAttribute("ias",isrv.readItemAtt());
        return "admin/item";
    }

    @GetMapping("/item/category/{category}")
    public String item(Model m,@PathVariable String category){
        logger.info("admin/item/category/~ 호출");
        m.addAttribute("ias",isrv.readItemAttCt(category));
        return "admin/item";
    }

    @GetMapping("/item/make")
    public String makeitem(){
        logger.info("admin/item/makeitem 호출");
        return "admin/makeItem";
    }

    @PostMapping("/item/make")
    public String makeitemok(Item i, MultipartFile attach){
        logger.info("admin/item/makeitemok 호출");
        String returnPage="redirect:/fail";
        int itemId=isrv.newItem(i);
        if(!attach.isEmpty()){
            isrv.newItemAttach(attach,itemId);
            returnPage="redirect:/admin/item";
        }

        return returnPage;
    }

    @GetMapping("/item/modify/{item_id}")
    public String modifyitem(Model m,@PathVariable String item_id){
        logger.info("admin/item/modify 호출");
        m.addAttribute("i",isrv.readOneItem(item_id));
        return "admin/modifyItem";
    }

    @PostMapping("/item/modify/{item_id}") /*이미지 수정 x , 내용만 수정*/
    public String modifyitem(Item i,@PathVariable String item_id){
        logger.info("admin/item/modify 호출");
        String returnPage="redirect:/fail";
        i.setItem_id(item_id);
        if(isrv.modifyOneItem(i))
            returnPage="redirect:/admin/item";
        return returnPage;
    }
    @PostMapping("/item/modifyI/{item_id}") /*이미지 수정 o */
    public String modifyIitem(Item i,@PathVariable String item_id,MultipartFile attach){
        logger.info("admin/item/modifyI 호출");
        String returnPage="redirect:/fail";
        i.setItem_id(item_id);
        if(!attach.isEmpty()){
            isrv.modifyIOneItem(i,attach);
            returnPage="redirect:/admin/item";
        }
        return returnPage;
    }

    @GetMapping("/itemDelete/{item_id}")
    public String itemDelete(@PathVariable String item_id){
        logger.info("admin/itemDelete 호출");
        String returnPage="redirect:/fail";
        if(isrv.removeItem(item_id))
            returnPage="redirect:/admin/item";
        return returnPage;
    }

    @GetMapping("/qna/list/{cpg}")
    public String qna(Model m,@PathVariable Integer cpg){
        logger.info("admin/qna 호출");
        m.addAttribute("qnas",a_qsrv.readQna(cpg));
        m.addAttribute("stpg",5*((cpg-1)/5)+1);
        m.addAttribute("cntpg",a_qsrv.getCountPages());
        m.addAttribute("cpg",cpg);
        //만일, cpg가 cntpg보다 크다면
        //1페이지로 강제 이동
        if(cpg > (int)m.getAttribute("cntpg"))
            return "redirect:/admin/qna/list/1";
        return "admin/qna";
    }

    @GetMapping("/itemqna/list/{cpg}")
    public String itemqna(Model m,@PathVariable Integer cpg){
        logger.info("admin/itemqna 호출");
        m.addAttribute("iqnas",a_qsrv.readItemQna(cpg));
        m.addAttribute("stpg",5*((cpg-1)/5)+1);
        m.addAttribute("cntpg",a_qsrv.getCountIQPages());
        m.addAttribute("cpg",cpg);
        if(cpg > (int)m.getAttribute("cntpg"))
            return "redirect:/admin/itemqna/list/1";
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
        String returnPage="redirect:/fail";
        if(a_qsrv.updateAdminReply(qid,answer))
            returnPage="redirect:/admin/qna/list/1";
        /*qid 글에 관리자 답변 넣어서 update*/
        return returnPage;
    }

    @GetMapping("/itemqna/{itemqna_id}")
    public String itemqnareply(Model m,@PathVariable String itemqna_id){
        logger.info("admin/itemqnareply 호출");
        /*q_no 글 불러오기*/
        m.addAttribute("iq",a_qsrv.readOneItemQna(itemqna_id));
        return "admin/itemqnareply";
    }
    @PostMapping("/itemqna/{itemqna_id}")
    public String itemqnareplyok(@PathVariable String itemqna_id,String answer){
        logger.info("admin/itemqnareplyok 호출");
        String returnPage="redirect:/fail";
        if(a_qsrv.updateAdminIReply(itemqna_id,answer))
            returnPage="redirect:/admin/itemqna";
        /*itemqna_id 글에 관리자 답변 넣어서 update*/
        return returnPage;
    }
    @GetMapping("/order")
    public String order(Model m){
        logger.info("admin/order 호출");

        return "admin/order";
    }

}
