package team.project.cooldown.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import team.project.cooldown.service.likes.LikesService;


@Controller
@RequiredArgsConstructor
public class LikesController {
    final LikesService lsrv;

}
