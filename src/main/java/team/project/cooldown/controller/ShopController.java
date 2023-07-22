package team.project.cooldown.controller;



import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.project.cooldown.service.item.ItemService;




@Controller

@RequiredArgsConstructor
public class ShopController {

    final ItemService isrv;

    @GetMapping("/digshop")
    public String digshop(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            if(sort == null){
                m.addAttribute("itemCombine",isrv.readItemCombine());
                return "shop/digshop";
            } else if(sort.equals("like")){
                return "shop/detail_item";
            }
            return "shop/digshop";
        } else {
            idx = 48;
            return "shop/detail_item";
        }
    }
    @GetMapping("/digbus_goods")
    public String digbus_goods(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            if(sort == null){
                m.addAttribute("itemCombine_d",isrv.readItemCombine_d());
                return "shop/digbus_goods";
            } else if(sort.equals("like")){
                return "shop/detail_item";
            }
            return "shop/digbus_goods";
        } else {
            idx = 48;
            return "shop/detail_item";
        }
    }
    @GetMapping("/campingitem")
    public String campingitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            if(sort == null){
                m.addAttribute("itemCombine_c",isrv.readItemCombine_c());
                return "shop/campingitem";
            } else if(sort.equals("like")){
                return "shop/detail_item";
            }
            return "shop/campingitem";
        } else {
            idx = 48;
            return "shop/detail_item";
        }
    }
    @GetMapping("/hikinhitem")
    public String hikinhitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            if(sort == null){
                m.addAttribute("itemCombine_h",isrv.readItemCombine_h());
                return "shop/hikinhitem";
            } else if(sort.equals("like")){
                return "shop/detail_item";
            }
            return "shop/hikinhitem";
        } else {
            idx = 48;
            return "shop/detail_item";
        }
    }
    @GetMapping("/bikeitem")
    public String bikeitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            if(sort == null){
                m.addAttribute("itemCombine_b",isrv.readItemCombine_b());
                return "shop/bikeitem";
            } else if(sort.equals("like")){
                return "shop/detail_item";
            }
            return "shop/bikeitem";
        } else {
            idx = 48;
            return "shop/detail_item";
        }
    }
    @GetMapping("/runningitem")
    public String runningitem(Model m,
                          @RequestParam(value="idx", required=false) Integer idx,
                          @RequestParam(value="sort", required=false) String sort) {
        if (idx == null) {
            if(sort == null){
                m.addAttribute("itemCombine_r",isrv.readItemCombine_r());
                return "shop/runningitem";
            } else if(sort.equals("like")){
                return "shop/detail_item";
            }
            return "shop/runningitem";
        } else {
            idx = 48;
            // 'idx' 값을 사용하여 필요한 작업을 수행합니다.
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