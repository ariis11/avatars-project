package com.aristidas.avatars.dto;

public class AvatarCreationResponseDTO {
    private Long id;
    private byte[] image;

    public AvatarCreationResponseDTO(Long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
