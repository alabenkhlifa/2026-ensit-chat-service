package tn.ensit.chatservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.ensit.chatservice.message.entities.Message;
import tn.ensit.chatservice.message.repositories.MessageRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final MessageRepository messageRepository;

    public DataSeeder(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) {
        if (messageRepository.count() > 0) return;

        for (int i = 0; i < 10; i++) {
            long sender = (i % 10) + 1;
            long receiver = ((i + 1) % 10) + 1;
            String channelId = "channel-" + Math.min(sender, receiver) + "-" + Math.max(sender, receiver);
            messageRepository.save(new Message(channelId, sender, receiver));
        }
    }
}
