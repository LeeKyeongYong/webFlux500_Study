package com.exambasic.fluxweb.controller;

import com.exambasic.fluxweb.entity.DataEntity;
import com.exambasic.fluxweb.service.MainService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@ResponseBody
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public Flux<DataEntity> mainP(){
        return mainService.getData();
    }

}



