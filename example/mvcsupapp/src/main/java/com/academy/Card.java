package com.academy;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Card {
    private String clientName;
    private String topic;
    private String message;

    private final Map<String, Attachment> attachments = new LinkedHashMap<>();

    public Card() {}

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    // === Работа с вложениями ===
    public Attachment getAttachment(String name) {
        return attachments.get(name);
    }

    public Collection<Attachment> getAttachments() {
        return attachments.values();
    }

    public void addAttachment(Attachment attachment) {
        if (attachment != null && attachment.getFileName() != null) {
            attachments.put(attachment.getFileName(), attachment);
        }
    }

    public int getNumberOfAttachments() {
        return attachments.size();
    }
}