package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Contact;
import ru.kpfu.itis.service.ContactService;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/")
    public String getContacts(Model model) {
        ArrayList list = (ArrayList) contactService.getALL();
        model.addAttribute("contacts", list);
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "add";
    }

    @RequestMapping(value = "/new_contact", method = RequestMethod.POST)
    public String add(@ModelAttribute("contact") @Valid Contact contact,
                      BindingResult bindingResult, Model model) {
        contactService.add(contact);

        if (bindingResult.hasErrors()) {
            model.addAttribute("contact", new Contact());
            model.addAttribute("result", "Could not add contact");
            return "add";
        }

        model.addAttribute("result", "Contact added successfully");
        return "add";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, @RequestParam("id") Long id, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            model.addAttribute("result", "Could not delete");
            return "redirect: /";
        }

        contactService.delete(id);
        model.addAttribute("result", "Deleted successfully");
        return "redirect: /";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPage(Model model, @RequestParam("id") Long id) {
        model.addAttribute("id", id);
        model.addAttribute("contact", new Contact());
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(Model model, @ModelAttribute("contact") @Valid Contact contact,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contact", new Contact());
            model.addAttribute("result", "Could not edit contact");
            return "edit";
        }
        contactService.edit(contact);
        model.addAttribute("result", "Edited successfully");
        return "redirect: /";
    }
}
