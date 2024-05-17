package com.jonathancomarella.newsletter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsDto {

    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    private String link;
    @JsonIgnore
    private LocalDate processed;
}
