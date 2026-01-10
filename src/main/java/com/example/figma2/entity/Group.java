package com.example.figma2.entity;


import com.example.figma2.entity.enums.Days;
import com.example.figma2.entity.template.AbsEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Group extends AbsEntity {

    private String name;

    private Boolean isActive;

   @ManyToOne
    private User teacherId;

    @ManyToOne
    private Room roomId;

    @CreationTimestamp
    private LocalDate start_date;
    private LocalDate start_time;

    private LocalDate end_time;
    private LocalDate end_date;
    @ManyToOne
    private Category CategoryID;

     @Enumerated(EnumType.STRING)
    private Days days;




}
