package com.unsomen.spring.data.jpa.service;

import com.unsomen.spring.data.jpa.model.CommentEntity;
import com.unsomen.spring.data.jpa.model.UserEntity;
import com.unsomen.spring.data.jpa.repository.CommentRepository;
import com.unsomen.spring.data.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public UserService(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public Long createUser(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        var newUser = userRepository.save(userEntity);
        return newUser.getId();
    }

    public UserEntity getUser(Long id) {
        var user = userRepository.findById(id);
        user.ifPresent(userEntity -> {
            var comments = commentRepository.findAllByAuthor(userEntity);
            userEntity.setComments(comments);
        });
        return user.orElseThrow();
    }

    public void addComment(UserEntity user, String commentText) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setAuthor(user);
        commentEntity.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        commentEntity.setText(commentText);

        commentRepository.save(commentEntity);
    }
}
