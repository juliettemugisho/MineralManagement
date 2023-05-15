package com.julliet.mineralproductmngt_sys.controller;
import com.julliet.mineralproductmngt_sys.DataTransferObject.UserRegistartionDto;
import com.julliet.mineralproductmngt_sys.service.UserInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserController {
    private final UserInterface userInterface;

    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }


    @ModelAttribute("user")
    public UserRegistartionDto userRegistartionDto(){
        return new UserRegistartionDto();
    }

   @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistartionDto dto){
        userInterface.saveAccount(dto);
        return "redirect:/registration?success";
    }
}
