package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardComments {
    private String reply_id;
    private String u_id;
    private String board_id;
    private String regdate;
    private String contents;
    private String report;
    private String ref;

    private User nick;
}
