package com.example.SharingIsCaring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends CrudRepository <UserProfile, Long> {
    Optional<UserProfile> getNewUserByUsernameAndPassword(String username, String password);
    Optional<UserProfile> getNewUserByUsername(String username);

    @Query(value ="SELECT id, name, username, password FROM USERPROFILE WHERE username = ?1 AND PASSWORD = ?2", nativeQuery = true)
    Optional <UserProfile> login(
            String username,
            String password
    );

}
