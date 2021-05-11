package com.patrickramosruas.thingstodo.service;

import com.patrickramosruas.thingstodo.entity.ThingsToDoEntity;
import com.patrickramosruas.thingstodo.resource.ThingsToDoRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ThingsToDoService {

    Optional<ThingsToDoEntity> save(ThingsToDoRequest thingsToDoRequest);
    ResponseEntity update(Long id, ThingsToDoRequest thingsToDoRequest);
    void deleteById(Long id);
    List<ThingsToDoEntity> findAll();

}
