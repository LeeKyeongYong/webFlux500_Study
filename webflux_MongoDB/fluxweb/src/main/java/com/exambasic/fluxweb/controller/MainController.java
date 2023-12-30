package com.exambasic.fluxweb.controller;

import com.exambasic.fluxweb.document.TableCollection;
import com.exambasic.fluxweb.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@ResponseBody
public class MainController {
    @Autowired
    private TableRepository mainService;

    @GetMapping("/")
    public Flux<TableCollection> mainP(){

        Flux<TableCollection> tempData = mainService.findAll();
        tempData.subscribe(x->{
            System.out.println(x.getData());
        });

        return mainService.findAll();

    }

}



