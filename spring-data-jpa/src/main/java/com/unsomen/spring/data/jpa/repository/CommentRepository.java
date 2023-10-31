package com.unsomen.spring.data.jpa.repository;

import com.unsomen.spring.data.jpa.model.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}
