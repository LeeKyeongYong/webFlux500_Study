package com.exambasic.fluxweb.service;

import com.exambasic.fluxweb.entity.DataEntity;
import com.exambasic.fluxweb.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MainService {

    @Autowired
    private DataRepository dataRepository;

    public Flux<DataEntity> getData(){
        return dataRepository.findAll();
    }
}

