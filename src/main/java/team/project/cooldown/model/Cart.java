package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {
    private String cart_id;
    private String u_id;
    private String item_id;
    private String count;
}
