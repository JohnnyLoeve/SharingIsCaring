package com.example.SharingIsCaring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository <UserProfile, Long> {
    Optional<UserProfile> getNewUserByUsernameAndPassword(String username, String password);

    @Query(value ="SELECT id, name, username, password FROM USER WHERE username = ?1 AND PASSWORD = ?2", nativeQuery = true)
    public UserProfile login(
            String username,
            String password);

}
