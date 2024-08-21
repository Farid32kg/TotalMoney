package com.example.back_end.controller;

import com.example.back_end.model.TotalAll;
import com.example.back_end.model.Totalmoney;
import com.example.back_end.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;


@Controller
public class TotalController {

    @Autowired
    private TotalService totalService;


    @GetMapping("/all")
    public String get(Model model){
        model.addAttribute("total",totalService.getAll());
        return "list-total";
    }

    @GetMapping("/update")
    public String update(Model model){
        TotalAll totalAll = new TotalAll();
        model.addAttribute("totalForm",totalAll);
        return "Update";
    }

    @PostMapping("/save-update")
    public String save(@ModelAttribute("totalForm") TotalAll totalAll){
        Totalmoney totalmoney = new Totalmoney();
        LocalDate localDate = LocalDate.now();
        double totalMoney = 0.0;
        totalMoney+=totalAll.getCash() +  totalAll.getKapital()+totalAll.getRabite();
        totalmoney.setName("Rabite: " + totalAll.getRabite() +"  Kapital: " + totalAll.getKapital() + " Cash: "+ totalAll.getCash());
        totalmoney.setTotal(String.valueOf(Math.round(totalMoney)));
        totalmoney.setDate(localDate.getDayOfMonth()+" " +localDate.getMonth()+ " "+ localDate.getYear());
        totalmoney.setNotes(totalAll.getNotes());
        String emailDate = localDate.getDayOfMonth() + " " + localDate.getMonth() + " " + localDate.getYear();
        String emailTotal= String.valueOf(totalMoney);
        totalService.senEmail("faridnagiyev@hotmail.com", emailDate,emailTotal+" azn.");
        totalService.save(totalmoney);
        return "redirect:/all";

    }



}
