package com.example.hellospring.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloController {
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String index(){
        return "<html>\n" + "<header><title>Welcome to my first Spring Application :O</title></header>\n" +
        "<body>\n" +"<a href=localhost:8080/first-mapping> First Mapping!</a>\n" +
        "<a href=localhost:8080/second-mapping> Second Mapping! </a>\n"
        + "</body>\n" + "</html>";
    }

    @GetMapping("/first-mapping")
    public String firstMapping(){
        return "Hello Spring!";
    }

    @GetMapping("/second-mapping")
    public String secondMapping(){
        return "this is the second mapping";
    }

    @GetMapping("/parameter")
    public String parameter(@RequestParam String param){
        return param + " " + "\uD83D\uDE01";
    }

    @GetMapping("/input")
    public String input(@RequestParam String input){
        return input;
    }

    @GetMapping("/erdetfredag")
    public String erDetFredag(){
        LocalDate currentDate = LocalDate.now();
        // Zeller's Algorithm:
        // q is the day of month (1-31)
        int day = currentDate.getDayOfMonth();
        // m is the month(1-12)
        int month = currentDate.getMonthValue();
        // j is the century (year/100)
        int cent = currentDate.getYear()/100;
        // k is the year of the century (year%100)
        int year = currentDate.getYear()%100;

        // 1st part of the algo
        int h = (day + ((13*(month+1))/5) + year + (year/4) + cent/4 -2*cent)%7;

        // Floor function of Zeller's Algorithm
        int weekday = ((h+5)%7)+1;
        if (weekday == 5){
            return "JA! Det er \uD83C\uDF7A ⌚";
        } else {
            return "Nej \uD83D\uDE2B";
        }
    }
}
