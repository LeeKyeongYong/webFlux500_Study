package com.exambasic.fluxweb.service;

import com.exambasic.fluxweb.document.TableCollection;
import com.exambasic.fluxweb.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TableCollectionService {

    private final TableRepository tableRepository;

    @Autowired
    public TableCollectionService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public Flux<TableCollection> getAllTableData() {
        return tableRepository.findAll();
    }

    public Mono<TableCollection> insertTableData(String newData) {
        TableCollection newEntry = new TableCollection();
        newEntry.setData(newData);
        return tableRepository.save(newEntry);
    }

}
