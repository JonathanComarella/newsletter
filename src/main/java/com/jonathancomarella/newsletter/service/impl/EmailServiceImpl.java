package com.jonathancomarella.newsletter.service.impl;

import com.jonathancomarella.newsletter.exception.EmailSendingException;
import com.jonathancomarella.newsletter.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired(required = true)
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
            logger.info("Email enviado com sucesso para {}", to);
        } catch (MessagingException e) {
            logger.error("Falha ao enviar e-mail para {}", to);
            throw new EmailSendingException("Falha ao enviar e-mail para " + to, e);
        }
    }
}
