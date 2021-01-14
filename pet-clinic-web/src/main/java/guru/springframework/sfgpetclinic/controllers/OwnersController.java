package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owners")
public class OwnersController {

    private final OwnerService ownerService;

    @Autowired
    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(Model model) {

        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "owners/index";

    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }

}
