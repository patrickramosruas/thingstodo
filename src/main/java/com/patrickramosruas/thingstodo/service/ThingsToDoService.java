package com.patrickramosruas.thingstodo.service;

import com.patrickramosruas.thingstodo.entity.ThingsToDoEntity;
import com.patrickramosruas.thingstodo.resource.ThingsToDoRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ThingsToDoService {

    ResponseEntity<ThingsToDoEntity> save(ThingsToDoRequest thingsToDoRequest);
    ResponseEntity update(Long id, ThingsToDoRequest thingsToDoRequest);
    ResponseEntity<?> deleteById(Long id);
    List findAll();
    ResponseEntity findById(Long id);

}
