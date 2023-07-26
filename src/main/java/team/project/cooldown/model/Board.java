package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
    private String board_id;
    private String category;
    private String title;
    private String u_id;
    private String views;
    private String contents;
    private String likes;
    private String regdate;

    private BoardAttach ba;
    private User nick;
}
