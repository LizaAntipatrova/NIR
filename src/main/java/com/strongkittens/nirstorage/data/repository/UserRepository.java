package com.strongkittens.nirstorage.data.repository;

import com.strongkittens.nirstorage.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);

    User findUserById(long id);
}
