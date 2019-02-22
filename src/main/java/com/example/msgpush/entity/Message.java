package com.example.msgpush.entity;

/**
 * 定义消息
 */
public class Message {
    private String id;
    private String theme;
    private String content;
    private String type;
    private int level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                '}';
    }
}
