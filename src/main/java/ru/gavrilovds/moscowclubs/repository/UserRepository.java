package ru.gavrilovds.moscowclubs.repository;

import ru.gavrilovds.moscowclubs.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    UserEntity findByToken(String token);
}
