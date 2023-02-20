package com.example.SharingIsCaring;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CreateUserRepo extends CrudRepository <CreateUser, Long> {
    Optional<CreateUser> getNewUserByUsernameAndPassword(String username, String password);

}
