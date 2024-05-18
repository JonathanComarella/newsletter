package com.jonathancomarella.newsletter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsDto {

    private Long id;
    @NotNull
    @Size(max = 200)
    private String title;
    @NotNull
    @Size(max = 900)
    private String description;
    @Size(max = 1000)
    private String link;
    @JsonIgnore
    private LocalDate processed;
}
