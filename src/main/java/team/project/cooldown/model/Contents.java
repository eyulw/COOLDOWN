package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contents {
    private String contents_id;
    private String title;
    private String u_id;
    private String views;
    private String contents;
    private String likes;
    private String regdate;
}
