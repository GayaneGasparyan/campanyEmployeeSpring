package com.example.campanyemployeespring.controller;

import com.example.campanyemployeespring.model.Employee;
import com.example.campanyemployeespring.model.Topic;
import com.example.campanyemployeespring.repository.TopicRepository;
import com.example.campanyemployeespring.security.CurrentUser;
import com.example.campanyemployeespring.service.EmployeeService;
import com.example.campanyemployeespring.service.TopicService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class TopicController {
    private TopicService topicService;
private EmployeeService employeeService;

    @GetMapping("/addTopic")
    public String addTopic(ModelMap modelMap) {
        List<Topic> all = topicService.findAll();
        modelMap.addAttribute("topics", all);
        List<Employee> empl = employeeService.findAll();
        modelMap.addAttribute("employees", empl);
        return "addTopic";
    }



    @PostMapping("/employee/addTopic")
    public String addTop(@ModelAttribute Topic topic, @AuthenticationPrincipal CurrentUser currentUser) {
        topic.setEmployee(currentUser.getEmployee());
        topic.setDate(new Date());
        topicService.save(topic);
        return "redirect: employees";
    }

    @GetMapping("/topics")
    public String topics(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Topic> topics = topicService.findAllTopicByEmployeeId(currentUser.getEmployee().getId());
        modelMap.addAttribute("topics", topics);
        return "topics";
    }

        @GetMapping("/deleteTopic")
        public String deleteTopic(@RequestParam("id") int id) {
            employeeService.deleteTopicByEmployeeId(id);
            topicService.deleteById(id);
            return "redirect:/companies";
        }

        @GetMapping("/showMessage")
        public String addMess(ModelMap modelMap) {
            List<Topic> all = topicService.findAll();
            modelMap.addAttribute("topics", all);
            List<Employee> empl = employeeService.findAll();
            modelMap.addAttribute("employees", empl);
            return "showMessage";
        }

    }


