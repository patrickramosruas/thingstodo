package com.patrickramosruas.thingstodo.resource;

import com.patrickramosruas.thingstodo.entity.ThingsToDoEntity;
import com.patrickramosruas.thingstodo.service.ThingsToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/thingstodo")
@RequiredArgsConstructor
public class ThingsToDoResource {

    private final ThingsToDoService thingsToDoService;

    @GetMapping()
    public ResponseEntity<List<ThingsToDoEntity>> findAll(){

        return ResponseEntity.status(HttpStatus.OK).body(thingsToDoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        return thingsToDoService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<ThingsToDoEntity> save(@RequestBody ThingsToDoRequest thingsToDoRequest){

        return thingsToDoService.save(thingsToDoRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        return thingsToDoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ThingsToDoRequest thingsToDoRequest){

        return thingsToDoService.update(id,thingsToDoRequest);
    }


}
