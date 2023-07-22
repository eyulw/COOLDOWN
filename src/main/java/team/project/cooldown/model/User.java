package team.project.cooldown.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String u_id;
    private String userid;
    private String password;
    private String email;
    private String nickname;
    private String phone;
    private String zipcode;
    private String address1;
    private String address2;
    private String birth;
    private String username;
    private String regdate;
    private String role;
}
