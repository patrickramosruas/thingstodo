package com.patrickramosruas.thingstodo.service;

import com.patrickramosruas.thingstodo.entity.ThingsToDoEntity;
import com.patrickramosruas.thingstodo.repository.ThingsToDoRepository;
import com.patrickramosruas.thingstodo.resource.ThingsToDoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThingsToDoServiceImpl implements ThingsToDoService {

    public final ThingsToDoRepository thingsToDoRepository;

    @Override
    public ResponseEntity<ThingsToDoEntity> save(ThingsToDoRequest thingsToDoRequest) {

        final ThingsToDoEntity thingsToDoEntity = ThingsToDoEntity.builder()
                .title(thingsToDoRequest.getTitle())
                .description(thingsToDoRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .expiresAt(thingsToDoRequest.getExpiresAt())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(thingsToDoRepository.save(thingsToDoEntity));
    }

    @Override
    public ResponseEntity update(Long id, ThingsToDoRequest thingsToDoRequest) {
        return thingsToDoRepository.findById(id)
                .map(toDo -> {
                    toDo.setCreatedAt(LocalDateTime.now());
                    toDo.setDescription(thingsToDoRequest.getDescription());
                    toDo.setTitle(thingsToDoRequest.getTitle());
                    toDo.setExpiresAt(thingsToDoRequest.getExpiresAt());
                    ThingsToDoEntity updated = thingsToDoRepository.save(toDo);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return thingsToDoRepository.findById(id)
                .map(toDo -> {
                    thingsToDoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List findAll() {
        return thingsToDoRepository.findAll();
    }

    @Override
    public ResponseEntity findById(Long id) {
        return thingsToDoRepository.findById(id)
                .map(toDo-> ResponseEntity.ok().body(toDo))
                .orElse(ResponseEntity.notFound().build());
    }
}
