package com.example.challengespringboot.Repositories;

import com.example.challengespringboot.Models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Long> {

    //@Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<UserApp> findUserByEmail(String email);

    UserApp findUserByName(String name);

}
