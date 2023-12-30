package com.exambasic.fluxweb.controller;

import com.exambasic.fluxweb.first.entity.FirstEntity;
import com.exambasic.fluxweb.first.repository.FirstRepository;
import com.exambasic.fluxweb.second.entity.SecondEntity;
import com.exambasic.fluxweb.second.repository.SecondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
public class NewMainController {

    @Autowired
    private FirstRepository firstRepository;

    @Autowired
    private SecondRepository secondRepository;
 @GetMapping("/hi")
 @ResponseBody
 public String mainP(){

     Flux<FirstEntity> data1 = firstRepository.findAll();
    data1.subscribe(x -> {
        System.out.println(x);
    });

    Flux<SecondEntity> data2= secondRepository.findAll();
    data2.subscribe(x -> {
        System.out.println(x);
    });

     return "hi";
   }
}
