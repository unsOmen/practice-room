package com.unsomen.aspects.service;

import com.unsomen.aspects.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private static final List<User> USERS = new ArrayList<>();

    public String addUser(String name) {
        var newUser = new User();
        newUser.setUid(UUID.randomUUID().toString());
        newUser.setName(name);
        newUser.setActive(true);
        USERS.add(newUser);

        return newUser.getUid();
    }
}
