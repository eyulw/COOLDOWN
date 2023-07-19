package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailedOrders {
    private String d_orderid;
    private String order_id;
    private String item_id;
    private String quantity;
    private String totalcost;
}
