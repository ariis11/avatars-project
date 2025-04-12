package com.aristidas.avatars.service;

import com.aristidas.avatars.model.Question;
import com.aristidas.avatars.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AIService aiService;

    public Question generateQuestion(String country, String difficulty) {
        Question question = aiService.generateAIQuestion(country, difficulty);

        return questionRepository.save(question);
    }
}
