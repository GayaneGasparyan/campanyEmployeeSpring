package com.example.campanyemployeespring.repository;

import com.example.campanyemployeespring.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {


    List<Topic> findAllByEmployee_id(int id);
List<Topic> deleteTopicByEmployee_Id(int id);


}