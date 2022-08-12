package hlybchenko.librarian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class StartController {

    @GetMapping()
    private String startPage(){
        return "start";
    }
}