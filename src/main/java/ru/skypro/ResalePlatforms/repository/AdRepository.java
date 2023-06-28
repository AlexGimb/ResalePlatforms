package ru.skypro.ResalePlatforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.ResalePlatforms.entity.Ad;

public interface AdRepository extends JpaRepository<Ad, Integer> {
}
