package ru.gavrilovds.moscowclubs.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gavrilovds.moscowclubs.entity.CommentEntity;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}
