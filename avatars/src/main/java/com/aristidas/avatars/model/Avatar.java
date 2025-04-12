package com.aristidas.avatars.model;

import jakarta.persistence.*;

@Entity
@Table(name = "agent")
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "agent_age")
    private Short agentAge;

    @Column(name = "gender")
    private String gender;

    @Column(name = "skin_tone")
    private String skinTone;

    @Column(name = "hair_length")
    private String hairLength;

    @Column(name = "hair_shape")
    private String hairShape;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "eyes_color")
    private String eyesColor;

    @Column(name = "eyelashes_length")
    private String eyelashesLength;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "agent_type")
    private String agentType;

    @Column(name = "agent_name")
    private String agentName;

    @Column(name = "agent_language")
    private String agentLanguage;

    @Column(name = "voice")
    private String voice;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "knowledge_source")
    private String knowledgeSource;

    public Avatar() {
    }

    public Avatar(String nationality, Short agentAge, String gender, String skinTone, String hairLength, String hairShape, String hairColor, String eyesColor, String eyelashesLength, byte[] image) {
        this.nationality = nationality;
        this.agentAge = agentAge;
        this.gender = gender;
        this.skinTone = skinTone;
        this.hairLength = hairLength;
        this.hairShape = hairShape;
        this.hairColor = hairColor;
        this.eyesColor = eyesColor;
        this.eyelashesLength = eyelashesLength;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Short getAgentAge() {
        return agentAge;
    }

    public void setAgentAge(Short agentAge) {
        this.agentAge = agentAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkinTone() {
        return skinTone;
    }

    public void setSkinTone(String skinTone) {
        this.skinTone = skinTone;
    }

    public String getHairLength() {
        return hairLength;
    }

    public void setHairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    public String getHairShape() {
        return hairShape;
    }

    public void setHairShape(String hairShape) {
        this.hairShape = hairShape;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    public String getEyelashesLength() {
        return eyelashesLength;
    }

    public void setEyelashesLength(String eyelashesLength) {
        this.eyelashesLength = eyelashesLength;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentLanguage() {
        return agentLanguage;
    }

    public void setAgentLanguage(String agentLanguage) {
        this.agentLanguage = agentLanguage;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getKnowledgeSource() {
        return knowledgeSource;
    }

    public void setKnowledgeSource(String knowledgeSource) {
        this.knowledgeSource = knowledgeSource;
    }
}
