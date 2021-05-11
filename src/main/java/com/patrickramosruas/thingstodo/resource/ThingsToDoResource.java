package com.patrickramosruas.thingstodo.resource;

import com.patrickramosruas.thingstodo.entity.ThingsToDoEntity;
import com.patrickramosruas.thingstodo.repository.ThingsToDoRepository;
import com.patrickramosruas.thingstodo.service.ThingsToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/thingstodo")
@RequiredArgsConstructor
public class ThingsToDoResource {

    private final ThingsToDoService thingsToDoService;
    private final ThingsToDoRepository thingsToDoRepository;

    @GetMapping()
    public ResponseEntity<List<ThingsToDoEntity>> findAll(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(thingsToDoService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<ThingsToDoResponse> save(@RequestBody ThingsToDoRequest thingsToDoRequest){

        final ThingsToDoEntity thingsToDoEntity = thingsToDoService.save(thingsToDoRequest).orElseThrow();
        final ThingsToDoResponse thingsToDoResponse = ThingsToDoResponse.builder()
                .id(thingsToDoEntity.getId())
                .title(thingsToDoEntity.getTitle())
                .description((thingsToDoEntity.getDescription()))
                .createdAt(thingsToDoEntity.getCreatedAt())
                .expiresAt(thingsToDoEntity.getExpiresAt())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(thingsToDoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ThingsToDoResponse> deleteById(@PathVariable Long id){

        thingsToDoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ThingsToDoRequest thingsToDoRequest){
        return thingsToDoService.update(id,thingsToDoRequest);

    }

}
