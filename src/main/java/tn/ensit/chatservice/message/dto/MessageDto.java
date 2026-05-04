package tn.ensit.chatservice.message.dto;

public class MessageDto {
    private String channelId;

    private Long senderId;
    private Long receiverId;
    private String content;

    public MessageDto(String channelId, Long authorId, String content) {
        this.channelId = channelId;
        this.senderId = senderId;
        this.content = content;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }
}
