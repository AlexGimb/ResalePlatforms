package ru.skypro.ResalePlatforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.ResalePlatforms.entity.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {
}
