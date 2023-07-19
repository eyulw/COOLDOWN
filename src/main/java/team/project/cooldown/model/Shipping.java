package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Shipping {
    private String shipping_id;
    private String order_id;
    private String zipcode;
    private String address1;
    private String address2;
}
