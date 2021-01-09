package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersController {

    @RequestMapping({"", "/", "/index", "/index.html"})

    private String listOfOwners() {

        return "owners/index";

    }

}
