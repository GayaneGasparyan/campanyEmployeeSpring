package com.example.campanyemployeespring.service;

import com.example.campanyemployeespring.model.Message;
import com.example.campanyemployeespring.model.Topic;
import com.example.campanyemployeespring.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {


    private  final TopicRepository topicRepository;


    public void save(Topic topic ) {
        topicRepository.save(topic);

    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
    public void deleteById(int id) {

    }
    public List<Topic> findAllTopicByEmployeeId(int id) {
        return topicRepository.findAllByEmployee_id(id);
    }

}
