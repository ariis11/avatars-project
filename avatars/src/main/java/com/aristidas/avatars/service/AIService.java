package com.aristidas.avatars.service;

import com.aristidas.avatars.dto.ChatRequestDTO;
import com.aristidas.avatars.dto.ChatResponseDTO;
import com.aristidas.avatars.dto.ImageMessageDTO;
import com.aristidas.avatars.model.Question;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {
    @Value("${ai.api.url}")
    private String apiUrl;

    @Value("${ai.api.key}")
    private String apiKey;

    @Value("${ai.api.model}")
    private String model;

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LogManager.getLogger(AIService.class);

    public byte[] generateAIImage(String promptText) {
        ImageMessageDTO prompt = new ImageMessageDTO(promptText, 1, "1024x1024", "dall-e-3");

        // Serialize prompt object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPrompt;
        try {
            jsonPrompt = objectMapper.writeValueAsString(prompt);
        } catch (JsonProcessingException e) {
            logger.error("Error serializing prompt to JSON", e);
            return null;
        }

        // Send request with JSON prompt
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(apiKey);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonPrompt, headers);

        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(apiUrl + "/images/generations", HttpMethod.POST, requestEntity, byte[].class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle error response
            return null;
        }
    }

    public Question generateAIQuestion(String country, String difficulty) {
        String prompt = createPrompt(country, difficulty);

        ChatRequestDTO request = new ChatRequestDTO(model, prompt);
        ChatResponseDTO response = restTemplate.postForObject(apiUrl + "/chat/completions", request, ChatResponseDTO.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return null;
        }

        try {
            return parseResponseToQuestion(response.getChoices().get(0).getMessage().getContent(), country, difficulty);
        } catch (Exception e) {
            logger.error("Error parsing response to question", e);
            return null;
        }
    }

    private String createPrompt(String country, String difficulty) {
        return String.format("Create a %s trivia question about %s. Question can't ask what is the capital. Response should be provided in this json format: { \"question\": \"\", \"options\": { \"1\": \"\", \"2\": \"\", \"3\": \"\" },\"answer\": \"1/2/3\" }", difficulty, country);
    }

    private Question parseResponseToQuestion(String response, String country, String difficulty) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode optionsNode = rootNode.path("options");

        Question question = new Question();
        question.setCategory(country);
        question.setDifficultyLevel(difficulty);
        question.setQuestionText(rootNode.path("question").asText());
        question.setOption1(optionsNode.path("1").asText());
        question.setOption2(optionsNode.path("2").asText());
        question.setOption3(optionsNode.path("3").asText());
        question.setCorrectAnswer(optionsNode.path(rootNode.path("answer").asText()).asText());

        return question;
    }
}
