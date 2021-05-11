package com.patrickramosruas.thingstodo.repository;

import com.patrickramosruas.thingstodo.entity.ThingsToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingsToDoRepository extends JpaRepository<ThingsToDoEntity, Long> {

}
