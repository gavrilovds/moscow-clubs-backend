package ru.gavrilovds.moscowclubs.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gavrilovds.moscowclubs.entity.ClubEntity;

import java.util.List;

public interface ClubRepository extends CrudRepository<ClubEntity, Long> {
    ClubEntity findByName(String name);
    List<ClubEntity> getAllBy();
}
