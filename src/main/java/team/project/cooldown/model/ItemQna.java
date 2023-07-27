package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemQna {
    private String itemqna_id;
    private String u_id;
    private String item_id;
    private String title;
    private String contents;
    private String regdate;
    private String secret;
    private String answer;

    private User ua;
    private Item ia;
}
