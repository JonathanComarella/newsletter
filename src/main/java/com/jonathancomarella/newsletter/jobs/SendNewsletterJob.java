package com.jonathancomarella.newsletter.jobs;

import com.jonathancomarella.newsletter.service.NewsletterService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendNewsletterJob implements Job {

    @Autowired
    private NewsletterService newsletterService;

    public SendNewsletterJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        newsletterService.sendNewsletter();
    }
}
