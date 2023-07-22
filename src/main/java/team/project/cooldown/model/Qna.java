package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Qna {
    private String qna_id;
    private String u_id;
    private String title;
    private String contents;
    private String regdate;
    private String answer;

    private User ua;
}
