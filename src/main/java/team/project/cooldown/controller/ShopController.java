package team.project.cooldown.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.project.cooldown.model.Cart;
import team.project.cooldown.model.CartCombine;
import team.project.cooldown.service.item.ItemService;
import team.project.cooldown.service.likes.LikesService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller

@RequiredArgsConstructor
public class ShopController {

    final ItemService isrv;
    final LikesService lsrv;
    Map<String, String> sortOptions;
    Map<String, String> sortOptions_d;
    Map<String, String> sortOptions_c;
    Map<String, String> sortOptions_h;
    Map<String, String> sortOptions_b;
    Map<String, String> sortOptions_r;


    /*기본 상품리스트페이지와 상품상세페이지 같은주소*/


        // 세션에서 아이디 값 가져오기

    @GetMapping("/digshop")
    public String digshop(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort,
                          HttpServletRequest request) {


        if (idx == null) {
            sortOptions = new HashMap<>();
            sortOptions.put("recent", "recent");
            sortOptions.put("min_price", "min_price");
            sortOptions.put("max_price", "max_price");
            sortOptions.put("like", "like");
            sortOptions.put("abc", "abc");
            sortOptions.put("descabc", "descabc");

            // 기본값 설정
            if (sort == null || !sortOptions.containsKey(sort)) {
                sort = "recent";
            }

            m.addAttribute("itemCombine", isrv.readItemCombine(sortOptions.get(sort),null));
            return "shop/digshop";

        } else {

            m.addAttribute("itemCombine_d", isrv.readItemCombine("recent",idx));//idx값에 맞는 데이터 하나만 불러옴

            return "shop/detail_item";
        }
    }
    @GetMapping("/digbus_goods")
    public String digbus_goods(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            sortOptions_d = new HashMap<>();
            sortOptions_d.put("recent", "recent");
            sortOptions_d.put("min_price", "min_price");
            sortOptions_d.put("max_price", "max_price");
            sortOptions_d.put("like", "like");
            sortOptions_d.put("abc", "abc");
            sortOptions_d.put("descabc", "descabc");

            // 기본값 설정
            if (sort == null || !sortOptions_d.containsKey(sort)) {
                sort = "recent";
            }

            m.addAttribute("itemCombine", isrv.readItemCombine_d(sortOptions_d.get(sort),null));
            return "shop/digbus_goods";
        } else {
            m.addAttribute("itemCombine_d", isrv.readItemCombine_d("recent",idx));//idx값에 맞는 데이터 하나만 불러옴
            return "shop/detail_item";
        }
    }
    @GetMapping("/campingitem")
    public String campingitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            sortOptions_c = new HashMap<>();
            sortOptions_c.put("recent", "recent");
            sortOptions_c.put("min_price", "min_price");
            sortOptions_c.put("max_price", "max_price");
            sortOptions_c.put("like", "like");
            sortOptions_c.put("abc", "abc");
            sortOptions_c.put("descabc", "descabc");

            // 기본값 설정
            if (sort == null || !sortOptions_c.containsKey(sort)) {
                sort = "recent";
            }

            m.addAttribute("itemCombine", isrv.readItemCombine_c(sortOptions_c.get(sort),null));
            return "shop/campingitem";
        } else {
            m.addAttribute("itemCombine_d", isrv.readItemCombine_c("recent",idx));//idx값에 맞는 데이터 하나만 불러옴
            return "shop/detail_item";
        }
    }
    @GetMapping("/hikinhitem")
    public String hikinhitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            sortOptions_h = new HashMap<>();
            sortOptions_h.put("recent", "recent");
            sortOptions_h.put("min_price", "min_price");
            sortOptions_h.put("max_price", "max_price");
            sortOptions_h.put("like", "like");
            sortOptions_h.put("abc", "abc");
            sortOptions_h.put("descabc", "descabc");

            // 기본값 설정
            if (sort == null || !sortOptions_h.containsKey(sort)) {
                sort = "recent";
            }

            m.addAttribute("itemCombine", isrv.readItemCombine_h(sortOptions_h.get(sort),null));
            return "shop/hikinhitem";
        } else {
            m.addAttribute("itemCombine_d", isrv.readItemCombine_h("recent",idx));//idx값에 맞는 데이터 하나만 불러옴
            return "shop/detail_item";
        }
    }
    @GetMapping("/bikeitem")
    public String bikeitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            sortOptions_b = new HashMap<>();
            sortOptions_b.put("recent", "recent");
            sortOptions_b.put("min_price", "min_price");
            sortOptions_b.put("max_price", "max_price");
            sortOptions_b.put("like", "like");
            sortOptions_b.put("abc", "abc");
            sortOptions_b.put("descabc", "descabc");

            // 기본값 설정
            if (sort == null || !sortOptions_b.containsKey(sort)) {
                sort = "recent";
            }

            m.addAttribute("itemCombine", isrv.readItemCombine_b(sortOptions_b.get(sort),null));
            return "shop/bikeitem";
        } else {
            m.addAttribute("itemCombine_d", isrv.readItemCombine_b("recent",idx));//idx값에 맞는 데이터 하나만 불러옴
            return "shop/detail_item";
        }
    }
    @GetMapping("/runningitem")
    public String runningitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            sortOptions_r = new HashMap<>();
            sortOptions_r.put("recent", "recent");
            sortOptions_r.put("min_price", "min_price");
            sortOptions_r.put("max_price", "max_price");
            sortOptions_r.put("like", "like");
            sortOptions_r.put("abc", "abc");
            sortOptions_r.put("descabc", "descabc");

            // 기본값 설정
            if (sort == null || !sortOptions_r.containsKey(sort)) {
                sort = "recent";
            }

            m.addAttribute("itemCombine", isrv.readItemCombine_r(sortOptions_r.get(sort),null));
            return "shop/runningitem";
        } else {
            m.addAttribute("itemCombine_d", isrv.readItemCombine_r("recent",idx));//idx값에 맞는 데이터 하나만 불러옴
            return "shop/detail_item";
        }
    }

    // itemlist

    @GetMapping("/likes/{item_id}")
    @ResponseBody
    public void toggleLike(HttpSession session, @PathVariable Integer item_id, HttpServletResponse res) throws IOException {
        String u_id = (String) session.getAttribute("u_id");

        lsrv.allLikes(u_id, item_id);

        res.getWriter().print(lsrv.currentLikesCount(item_id));
    }




    @PostMapping("/shop_cart/{item_id}/{count}")
    public void shop_cart_add(HttpSession session,@PathVariable Integer item_id,@PathVariable Integer count) {
        String u_id = (String) session.getAttribute("u_id");
        System.out.println("아이디"+u_id);
        System.out.println("아이템"+item_id);
        System.out.println("갯수"+count);


         isrv.addCart(u_id, item_id, count);

    }
    @GetMapping("/shop_cart")
    public String shop_cart(Model m,HttpSession session) throws JsonProcessingException {
        String u_id = (String) session.getAttribute("u_id");
        List<CartCombine> carts = isrv.chooseCart(u_id);
        m.addAttribute("ChooseCart", isrv.chooseCart(u_id));
        return "shop/shop_cart";
    }

@PostMapping("/updateCartCount")
@ResponseBody
public void updateCartCount(@RequestBody CartCombine request) {

        isrv.updateCartCount(request.getCart_id(), request.getCount());

}

@PostMapping("/removeCart")
@ResponseBody
public void removeCart(@RequestBody CartCombine request) {

    isrv.removeCart(request.getCart_id());

}





    @GetMapping("/shop_payment")
    public String shop_payment() {

        return "shop/shop_payment";
    }






}