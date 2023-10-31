package com.unsomen.spring.data.jpa.repository;

import com.unsomen.spring.data.jpa.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByName(String name);
}
