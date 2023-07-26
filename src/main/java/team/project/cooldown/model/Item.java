package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
    private String item_id;
    private String category;
    private String itemname;
    private String price;
    private String likes;
    private String info;
    private String stock;
    private String likeusers;
}
