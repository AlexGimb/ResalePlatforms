package ru.skypro.ResalePlatforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.ResalePlatforms.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {
}

