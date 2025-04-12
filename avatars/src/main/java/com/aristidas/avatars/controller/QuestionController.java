package com.aristidas.avatars.controller;

import com.aristidas.avatars.model.Question;
import com.aristidas.avatars.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public Question generateQuestion(@RequestParam String country, @RequestParam String difficulty) {
        return questionService.generateQuestion(country, difficulty);
    }
}
