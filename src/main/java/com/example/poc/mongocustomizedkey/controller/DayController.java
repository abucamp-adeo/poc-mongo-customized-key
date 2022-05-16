package com.example.poc.mongocustomizedkey.controller;

import com.example.poc.mongocustomizedkey.model.Day;
import com.example.poc.mongocustomizedkey.model.DayRequest;
import com.example.poc.mongocustomizedkey.service.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;

    @PostMapping(path = "/day")
    @ResponseBody
    public Day saveTheDay(@RequestBody DayRequest dayRequest){
        return dayService.saveTheDay(dayRequest);
    }

}
