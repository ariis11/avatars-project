package com.aristidas.avatars.service;

import com.aristidas.avatars.dto.AvatarCharacteristicsDTO;
import com.aristidas.avatars.model.Avatar;
import com.aristidas.avatars.model.Question;
import com.aristidas.avatars.repository.AvatarRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;
    @Autowired
    private AIService aiService;
    @Autowired
    private ObjectMapper objectMapper;

    public byte[] generateImage(
            String nationality, Short agentAge, String gender, String skinTone,
            String hairLength, String hairShape, String hairColor, String eyesColor, String eyelashesLength
    ) throws JsonProcessingException {
        String prompt = "create a Disney Pixar-style image of a " + nationality + " " + agentAge + " " +
                gender + ", " + skinTone + " skin, with " + hairLength + " " + hairShape + " " + hairColor +
                " hair, very attractive, closed mouth, " + eyesColor + " eyes, " + eyelashesLength + " eyelashes and" +
                " medium eyebrows, moderate intensity freckels, 3D render, full HD, volumetric light, white background";
        byte[] imageData = aiService.generateAIImage(prompt);
        String jsonData = new String(imageData);
        JsonNode jsonNode = objectMapper.readTree(jsonData);
        String imageUrl = jsonNode.at("/data/0/url").asText();

        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = connection.getInputStream();

            return inputStream.readAllBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Avatar createAvatarWithImage(
            String nationality, Short agentAge, String gender, String skinTone,
            String hairLength, String hairShape, String hairColor, String eyesColor, String eyelashesLength
    ) throws JsonProcessingException {
        byte[] imageBytes = generateImage(nationality, agentAge, gender, skinTone, hairLength, hairShape, hairColor, eyesColor, eyelashesLength);

        Avatar avatar = new Avatar(nationality, agentAge, gender, skinTone, hairLength, hairShape, hairColor, eyesColor, eyelashesLength, imageBytes);

        return avatarRepository.save(avatar);
    }

    public List<Avatar> getAllAvatars() {
        return avatarRepository.findAll();
    }

    public List<Avatar> getAllEventHosts() {
        return avatarRepository.findByAgentType("host");
    }

    public List<Avatar> getAllInfluencers() {
        return avatarRepository.findByAgentType("influencer");
    }

    public void addCharacteristics(AvatarCharacteristicsDTO characteristics) {
        Avatar existingAvatar = avatarRepository.findById(characteristics.getId()).orElse(null);
        if (existingAvatar != null) {
            existingAvatar.setAgentName(characteristics.getName());
            existingAvatar.setVoice(characteristics.getVoice());
            existingAvatar.setAgentLanguage(characteristics.getLanguage());
            existingAvatar.setAgentType(characteristics.getType());

            avatarRepository.save(existingAvatar);
        }
    }
}
