package com.jonathancomarella.newsletter.controller;

import com.jonathancomarella.newsletter.dto.ClientDto;
import com.jonathancomarella.newsletter.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody @Valid ClientDto clientRequestDto) {
        ClientDto client = service.createClient(clientRequestDto);
        return ResponseEntity.ok().body(client);
    }
}
