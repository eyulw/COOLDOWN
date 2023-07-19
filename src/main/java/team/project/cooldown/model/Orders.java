package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    private String order_id;
    private String u_id;
    private String item_id;
    private String username;
    private String phone;
    private String email;
    private String zipcode;
    private String address1;
    private String address2;
    private String account_number;
    private String payment_amount;
}
