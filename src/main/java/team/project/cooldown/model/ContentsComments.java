package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContentsComments {
    private String c_reply_id;
    private String u_id;
    private String contents_id;
    private String regdate;
    private String contents;
    private String report;
    private String ref;
}
