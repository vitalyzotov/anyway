package org.jteam.anyway.domain.model;

public class Messenger {

    private String userName;
    /**
     *
     */
    private static String userId;
    /**
     *
     */
    private String messageType;
    /**
     *
     */
    private static String messageId;
    /**
     *
     */
    private String createdTime;
    /**
     *
     */
    private String recipientName;
    /**
     *
     */
    private static String recipientId;
    /**
     *
     */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        Messenger.userId = userId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public static String getMessageId() {
        return messageId;
    }

    public static void setMessageId(String messageId) {
        Messenger.messageId = messageId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public static String getRecipientId() {
        return recipientId;
    }

    public static void setRecipientId(String recipientId) {
        Messenger.recipientId = recipientId;
    }
}
