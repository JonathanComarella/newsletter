package com.jonathancomarella.newsletter.service.impl;

import com.jonathancomarella.newsletter.model.Client;
import com.jonathancomarella.newsletter.model.News;
import com.jonathancomarella.newsletter.repository.ClientRepository;
import com.jonathancomarella.newsletter.repository.NewsRepository;
import com.jonathancomarella.newsletter.service.EmailService;
import com.jonathancomarella.newsletter.service.NewsletterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NewsletterServiceImpl implements NewsletterService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private EmailService emailService;

    public void sendNewsletter() {
        logger.info("sendNewsletter() - inicializado!");

        List<Client> clientList = clientRepository.findAll();
        List<News> newsList = newsRepository.findByProcessedIsNull();

        if (newsList.isEmpty()) {
            logger.info("sendNewsletter() - Nenhuma notícia cadastrada para o dia de hoje. 0 e-mails enviados.");
        } else {
            clientList.forEach(client -> {
                String emailContent = buildEmailContent(client.getName(), client.getBirthDate(), newsList);
                emailService.sendEmail(client.getEmail(), "Notícias do dia!", emailContent);
            });

            LocalDate newDate = LocalDate.now();
            newsList.forEach(news -> {
                news.setProcessed(newDate);
                newsRepository.save(news);
            });
        }

        logger.info("sendNewsletter() - finalizado!");
    }

    private String buildEmailContent(String clientName, LocalDate birthDate, List<News> newsList) {
        StringBuilder content = new StringBuilder();

        content.append("<b>Bom dia ").append(clientName);
        if (birthDate != null && isBirthday(birthDate)) {
            content.append(", Feliz aniversário!</b><br>");
        } else {
            content.append("</b><br><br><br>");
        }

        for (News news : newsList) {
            content.append("<b>");
            if (news.getLink() != null) {
                content.append("<a href=\"").append(news.getLink()).append("\">");
            }
            content.append(news.getTitle());
            if (news.getLink() != null) {
                content.append("</a>");
            }
            content.append("</b><br>");
            content.append(news.getDescription()).append("<br><br><br>");
        }

        content.append("<b>Até a próxima!</b><br>");
        return content.toString();
    }

    private boolean isBirthday(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        return birthDate.getDayOfMonth() == today.getDayOfMonth() && birthDate.getMonth() == today.getMonth();
    }
}
