package com.aristidas.avatars.controller;

import com.aristidas.avatars.dto.AvatarCharacteristicsDTO;
import com.aristidas.avatars.dto.AvatarCreationResponseDTO;
import com.aristidas.avatars.model.Avatar;
import com.aristidas.avatars.model.Question;
import com.aristidas.avatars.service.AIService;
import com.aristidas.avatars.service.AvatarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/api/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/createAvatarGenerateImage")
    public ResponseEntity<AvatarCreationResponseDTO> createAvatarGenerateImage(
            @RequestParam String nationality, @RequestParam Short agentAge, @RequestParam String gender,
            @RequestParam String skinTone, @RequestParam String hairLength, @RequestParam String hairShape,
            @RequestParam String hairColor, @RequestParam String eyesColor, @RequestParam String eyelashesLength
    ) throws JsonProcessingException {
        Avatar avatar = avatarService.createAvatarWithImage(nationality, agentAge, gender, skinTone, hairLength, hairShape, hairColor, eyesColor, eyelashesLength);

        AvatarCreationResponseDTO response = new AvatarCreationResponseDTO(avatar.getId(), avatar.getImage());

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/addCharacteristics")
    public void addCharacteristics(@RequestBody AvatarCharacteristicsDTO characteristics) {
        avatarService.addCharacteristics(characteristics);
    }

    @GetMapping("/getAllAvatars")
    public List<Avatar> getAllAvatars() {
        return avatarService.getAllAvatars();
    }

    @GetMapping("/getAllEventHosts")
    public List<Avatar> getAllEventHosts() {
        return avatarService.getAllEventHosts();
    }

    @GetMapping("/getAllInfluencers")
    public List<Avatar> getAllInfluencers() {
        return avatarService.getAllInfluencers();
    }

    @GetMapping("/getVideo")
    public ResponseEntity<Resource> getVideo() {
        Resource videoFile = new PathResource("src/main/resources/static/carmenspeaking.mp4");

        try {
            Thread.sleep(20000); // 20 seconds in milliseconds
        } catch (InterruptedException e) {
            // Handle interruption if necessary
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(videoFile);
    }
}
