package tn.ensit.chatservice.message.entities;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channelId;



    private Long senderId;


    private Long receiver;
    public Message() {}

    public Message(String channelId, Long senderId, Long receiver) {
        this.channelId = channelId;
        this.senderId = senderId;
        this.receiver = receiver;
    }
    public Message(String channelId, Long receiver) {
        this.channelId = channelId;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setSenderId(Long sender) {
        this.senderId = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", channelId='" + channelId + '\'' +
                ", senderId=" + senderId +
                ", receiver=" + receiver +
                '}';
    }
}