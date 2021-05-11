package com.patrickramosruas.thingstodo.service;

import com.patrickramosruas.thingstodo.entity.ThingsToDoEntity;
import com.patrickramosruas.thingstodo.repository.ThingsToDoRepository;
import com.patrickramosruas.thingstodo.resource.ThingsToDoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThingsToDoServiceImpl implements ThingsToDoService {

    public final ThingsToDoRepository thingsToDoRepository;

    @Override
    public Optional<ThingsToDoEntity> save(ThingsToDoRequest thingsToDoRequest) {

        final ThingsToDoEntity thingsToDoEntity = ThingsToDoEntity.builder()
                .title(thingsToDoRequest.getTitle())
                .description(thingsToDoRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .expiresAt(thingsToDoRequest.getExpiresAt())
                .build();

        return Optional.of(thingsToDoRepository.save(thingsToDoEntity));
    }

    @Override
    public ResponseEntity update(Long id, ThingsToDoRequest thingsToDoRequest) {
        return thingsToDoRepository.findById(id)
                .map(record -> {
                    record.setCreatedAt(LocalDateTime.now());
                    record.setDescription(thingsToDoRequest.getDescription());
                    record.setTitle(thingsToDoRequest.getTitle());
                    record.setExpiresAt(thingsToDoRequest.getExpiresAt());
                    ThingsToDoEntity updated = thingsToDoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public void deleteById(Long id) {
        thingsToDoRepository.deleteById(id);
    }

    @Override
    public List<ThingsToDoEntity> findAll() {
        return thingsToDoRepository.findAll();
    }
}
