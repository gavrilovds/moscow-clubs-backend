package ru.gavrilovds.moscowclubs.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gavrilovds.moscowclubs.entity.EventEntity;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
}
