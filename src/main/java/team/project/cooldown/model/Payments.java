package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payments {
    private String payments_id;
    private String order_id;
    private String d_orderid;
    private String p_method;
    private String p_amount;
    private String p_status;
    private String p_date;
    private String bank_name;
    private String account_number;
    private String depositor_name;
    private String cart_transaction_id;
}
