/*
Name: Alexus Jenkins
Course: COP 3330C
Date: November 12th, 2023
Program Objective: Create a Form Submission Application

Purpose: Handles web application requests and responses for greetings.
 */

package com.alexusjenkins.formsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model,
                                 @RequestParam("date") String dateString) {
        // Parse the date string and set it in the greeting object
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, dateFormatter);
        greeting.setDate(date);

        model.addAttribute("greeting", greeting);
        return "result";
    }

}

