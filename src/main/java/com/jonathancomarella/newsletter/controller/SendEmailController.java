package com.jonathancomarella.newsletter.controller;

import com.jonathancomarella.newsletter.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "email")
public class SendEmailController {

    @Autowired
    private NewsletterService newsletterService;

    @PostMapping(value = "manually")
    public ResponseEntity<String> sendMailManually() {
        newsletterService.sendNewsletter();
        return ResponseEntity.ok("Email enviado manualmente com sucesso!");
    }
}
