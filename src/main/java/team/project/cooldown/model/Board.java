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
    private String img;
    private String likes;
    private String comment_count;
    private String regdate;
}
