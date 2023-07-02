package ru.skypro.ResalePlatforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.ResalePlatforms.entity.UserClient;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserClient, Integer> {
    Optional<UserClient> findByUsername (String username);
}


