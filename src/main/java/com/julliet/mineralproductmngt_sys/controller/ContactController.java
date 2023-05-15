package com.julliet.mineralproductmngt_sys.controller;

import com.julliet.mineralproductmngt_sys.model.Contact;
import com.julliet.mineralproductmngt_sys.service.ContactServises;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {
    private final ContactServises contactServises;

    public ContactController(ContactServises contactServises) {
        this.contactServises = contactServises;
    }
     @GetMapping("/contactus")
    public String viewContact(Model model){
        model.addAttribute("contact",new Contact());
        return "contactus";
    }

    @GetMapping ("/display/{email}")
    public String deleteContact(@PathVariable String email){
        contactServises.deleteContact(email);
        return "redirect:/display";
    }

    @GetMapping("/display")
    public String displayContact(Model model){
        model.addAttribute("display",contactServises.getAllContact());
        return "display-contactors";
    }


    @PostMapping("/regContactus")
    public String saveContactor(@ModelAttribute("contact") Contact contact,Model model){
        Contact contact1=contactServises.saveContact(contact);
        if (contact1!=null) {

            return "redirect:/contactus?success";
        }else {

            return "redirect:/contactus?error";
        }
    }
}
