package com.unsomen.aspects;

import com.unsomen.aspects.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    void testAddUser() {
        var testUserName = "test-user-1";
        var uid = userService.addUser(testUserName);
        log.info("RESULT: {}", uid);
        Assertions.assertNotNull(uid);
        Assertions.assertFalse(uid.startsWith("old"));

        var user = userService.getUser(uid);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(testUserName, user.getName());
        Assertions.assertEquals(uid, user.getUid());
    }

    @Test
    void testAddUserOld() {
        var testUserName = "old-test-user-1";
        var uid = userService.addUser("old-test-user-1");
        log.info("RESULT: {}", uid);
        Assertions.assertNotNull(uid);
        Assertions.assertTrue(uid.startsWith("old"));

        var user = userService.getUser(uid);
        Assertions.assertNull(user);

        var originalUid = uid.replace("old-", "");
        user = userService.getUser(originalUid);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(testUserName, user.getName());
        Assertions.assertEquals(originalUid, user.getUid());
    }
}
