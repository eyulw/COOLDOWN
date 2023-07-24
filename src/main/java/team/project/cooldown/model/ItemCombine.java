package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemCombine {
    // Item 클래스의 속성
    private String item_id;
    private String category;
    private String itemname;
    private String price;
    private String likes;
    private String info;
    private String stock;

    // ItemAttach 클래스의 속성
    private String iano;
    private String fname;
    private String fsize;
}