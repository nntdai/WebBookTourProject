package com.example.WebBookTour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendEmail(String toEmail, String subject, Map<String, Object> templateModel) throws MessagingException {
        // Tạo nội dung email từ template
        Context context = new Context();
        context.setVariables(templateModel); // Gán giá trị cho các biến trong template
        String emailContent = templateEngine.process("client/email-template", context);

        // Tạo MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(emailContent, true); // Nội dung email ở dạng HTML

        // Gửi email
        mailSender.send(message);
    }
}

