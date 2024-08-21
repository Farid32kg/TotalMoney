package com.example.back_end.service;

import com.example.back_end.model.TotalAll;
import com.example.back_end.model.Totalmoney;
import com.example.back_end.repository.TotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TotalService {


    @Autowired
    private TotalRepository totalRepository;

    @Autowired
    private JavaMailSender javaMailSender;


    public List<Totalmoney> getAll(){
        return totalRepository.findAll();
    }
    public Totalmoney save (Totalmoney totalmoney){
        return  totalRepository.save(totalmoney);
    }

    public void senEmail (String to , String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}
