package com.jonathancomarella.newsletter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDto {

    private Long id;
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    @Email
    private String email;
    private LocalDate birthDate;
}
