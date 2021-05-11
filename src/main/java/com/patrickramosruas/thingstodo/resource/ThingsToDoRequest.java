package com.patrickramosruas.thingstodo.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThingsToDoRequest implements Serializable {

    private String title;
    private String description;
    private LocalDateTime expiresAt;

}
