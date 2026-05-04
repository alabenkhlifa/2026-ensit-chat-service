package tn.ensit.chatservice.message.services;

import org.springframework.stereotype.Service;
import tn.ensit.chatservice.message.entities.Message;
import tn.ensit.chatservice.message.repositories.MessageRepository;
import tn.ensit.chatservice.message.dto.MessageDto;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MessageService {

    private static final Logger LOGGER = Logger.getLogger(MessageService.class.getName());

    private final MessageRepository messageRepository;
  //  private final Long userService;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
     //   this.userService = userService;
    }

    public Message saveMessage(MessageDto dto) {
        Optional<Long> user =null ;  //userService.getOneUser(dto.getReceiverId());
        if(user.isPresent()) {
            Message message = new Message(dto.getChannelId(), user.get());
            return messageRepository.save(message);
        } else {
            String message = "Error while saving Message, user with id %d does not exist.".formatted(dto.getReceiverId());
            LOGGER.severe(message);
            throw new RuntimeException(message);
        }
    }
    public List<Message> getMessagesBetween(Long sender, Long  receiver) {
        return messageRepository.findBySenderIdAndReceiver(sender, receiver);
    }
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}