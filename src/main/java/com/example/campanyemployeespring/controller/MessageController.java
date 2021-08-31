package com.example.campanyemployeespring.controller;

import com.example.campanyemployeespring.model.Employee;
import com.example.campanyemployeespring.model.Message;
import com.example.campanyemployeespring.security.CurrentUser;
import com.example.campanyemployeespring.service.EmployeeService;
import com.example.campanyemployeespring.service.MessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MessageController {
    private MessageService messageService;

    private EmployeeService employeeService;
    @GetMapping("/sendMessage")
    public String addMessage(ModelMap modelMap) {
        List<Employee> all = employeeService.findAll();
        modelMap.addAttribute("employees", all);
        return "sendMessage";
    }



    @GetMapping("/messages")
    public String messages(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Message> mess = messageService.findAllMessageByToId(currentUser.getEmployee().getId());
        modelMap.addAttribute("messages", mess);
        return "sendMessage";

    }



    @PostMapping("/sendMessage")
    public String addComment(@ModelAttribute Message message, @AuthenticationPrincipal CurrentUser currentUser) {
        message.setFromId(currentUser.getEmployee());
        messageService.save(message);
        return "redirect:/employees";
    }


}