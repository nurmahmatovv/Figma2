package com.example.figma2.payload;

import com.example.figma2.entity.enums.Days;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupDTO {

    @Schema(hidden = true)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private Integer teacherId;
    @NotBlank
    private Integer categoryId;
    @NotBlank
    private boolean isActive =true;
    @NotBlank
    private Integer roomId;
    @NotBlank
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate startTime;
    private LocalDate endTime;

    private Days days;


}
