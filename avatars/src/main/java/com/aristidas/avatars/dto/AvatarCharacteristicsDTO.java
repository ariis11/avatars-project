package com.aristidas.avatars.dto;

public class AvatarCharacteristicsDTO {
    private Long id;
    private String name;
    private String voice;
    private String language;
    private String type;

    public AvatarCharacteristicsDTO() {
    }

    public AvatarCharacteristicsDTO(Long id, String name, String voice, String language, String type) {
        this.id = id;
        this.name = name;
        this.voice = voice;
        this.language = language;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
