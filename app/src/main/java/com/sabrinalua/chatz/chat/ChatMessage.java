package com.sabrinalua.chatz.chat;

/**
 * Created by sabrinalua on 09/02/2017.
 */

public class ChatMessage {
    private String text;
    private String id;
    private boolean isMine;

    public ChatMessage(String text, String id, boolean isMine) {
        this.text = text;
        this.id = id;
        this.isMine = isMine;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }
}
