package com.unsomen.spring.data.jpa;

import com.unsomen.spring.data.jpa.repository.CommentRepository;
import com.unsomen.spring.data.jpa.repository.UserRepository;
import com.unsomen.spring.data.jpa.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@ComponentScan(basePackages = {
        "com.unsomen.spring.data.jpa",
})
public class TestDB {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void createUserTest() {
        var userId = userService.createUser("test_user_1");
        Assertions.assertNotNull(userId);
    }

    @Test
    public void getUserTest() {
        var userId = userService.createUser("test_user_2");
        Assertions.assertNotNull(userId);

        var user = userService.getUser(userId);
        Assertions.assertNotNull(user);
    }

    @Test
    public void addCommentTest() {
        var userId = userService.createUser("test_user_3");
        Assertions.assertNotNull(userId);

        var user = userService.getUser(userId);
        Assertions.assertNotNull(user);

        userService.addComment(user, "test-comment");
        user = userRepository.findUserEntityByName("test_user_3").orElseThrow();
        Assertions.assertNotNull(user.getComments());
        Assertions.assertFalse(user.getComments().isEmpty());
    }
}
