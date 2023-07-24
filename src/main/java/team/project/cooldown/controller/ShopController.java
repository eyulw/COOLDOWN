package team.project.cooldown.controller;



import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.project.cooldown.service.item.ItemService;


import java.util.HashMap;
import java.util.Map;


@Controller

@RequiredArgsConstructor
public class ShopController {

    final ItemService isrv;
    Map<String, String> sortOptions;
    Map<String, String> sortOptions_d;
    Map<String, String> sortOptions_c;
    Map<String, String> sortOptions_h;
    Map<String, String> sortOptions_b;
    Map<String, String> sortOptions_r;

    @GetMapping("/digshop")
    public String digshop(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {

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
           /* m.addAttribute("itemPrice", isrv.getItemPrice(idx));*/
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


    @GetMapping("/shop_cart")
    public String shop_cart() {

        return "shop/shop_cart";
    }

    @GetMapping("/shop_payment")
    public String shop_payment() {

        return "shop/shop_payment";
    }






}