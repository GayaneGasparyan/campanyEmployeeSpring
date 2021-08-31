package com.example.campanyemployeespring.repository;

import com.example.campanyemployeespring.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
List<Message> findAllByToId_id(int id);

}
