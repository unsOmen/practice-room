package com.unsomen.spring.data.jpa.repository;

import com.unsomen.spring.data.jpa.model.CommentEntity;
import com.unsomen.spring.data.jpa.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByAuthor(UserEntity author);
}
