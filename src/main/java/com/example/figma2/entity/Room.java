package com.example.figma2.entity;


import com.example.figma2.entity.template.AbsEntity;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Room extends AbsEntity {

    private String name;
    @CreationTimestamp
    private LocalDate start_time;
    private LocalDate end_time;

}
