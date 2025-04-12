package com.aristidas.avatars.dto;

public class ImageMessageDTO {
    private String prompt;
    private int n;
    private String size;
    private String model;

    public ImageMessageDTO(String prompt, int n, String size, String model) {
        this.prompt = prompt;
        this.n = n;
        this.size = size;
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
