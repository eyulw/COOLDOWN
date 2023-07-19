package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Alert {
    private String alert_id;
    private String u_id;
    private String alert_contents;
}
