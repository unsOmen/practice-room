package com.unsomen.aspects;

import com.unsomen.aspects.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    void testAddUser() {
        var uid1 = userService.addUser("test-user-1");
    }
}
