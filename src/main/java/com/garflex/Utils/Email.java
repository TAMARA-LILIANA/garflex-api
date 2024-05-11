package com.garflex.Utils;

import com.garflex.Utils.interfaces.IEmail;
import com.garflex.entity.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email implements IEmail {
    @Autowired
    private JavaMailSender emailSender;
    @Override
    public void SendEmail(Contacto contacto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(contacto.getEmail());
        mailMessage.setSubject(contacto.getTitulo());
        mailMessage.setText(contacto.getMensaje());
        emailSender.send(mailMessage);
    }
}
