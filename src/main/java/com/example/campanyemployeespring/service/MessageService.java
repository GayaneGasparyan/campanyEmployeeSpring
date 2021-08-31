package com.example.campanyemployeespring.service;

import com.example.campanyemployeespring.model.Message;
import com.example.campanyemployeespring.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {


    private  MessageRepository messageRepository;

    public void save(Message message) {
        messageRepository.save(message);

    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public List<Message> findAllMessageByToId(int id) {
        return messageRepository.findAllByToId_id(id);
    }

}
