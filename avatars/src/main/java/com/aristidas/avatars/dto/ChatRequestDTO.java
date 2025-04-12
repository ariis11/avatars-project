package com.aristidas.avatars.dto;

import java.util.ArrayList;
import java.util.List;

public class ChatRequestDTO {

    private String model;
    private List<MessageDTO> messages;

    public ChatRequestDTO(String model, String prompt) {
        this.model = model;

        this.messages = new ArrayList<>();
        this.messages.add(new MessageDTO("user", prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
}
