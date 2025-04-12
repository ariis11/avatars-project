package com.aristidas.avatars.dto;

import java.util.List;

public class ChatResponseDTO {

    private List<Choice> choices;

    public ChatResponseDTO() {
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {

        private int index;
        private MessageDTO message;

        public Choice() {
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public MessageDTO getMessage() {
            return message;
        }

        public void setMessage(MessageDTO message) {
            this.message = message;
        }
    }
}
