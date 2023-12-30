package com.exambasic.fluxweb.controller;

import com.exambasic.fluxweb.document.TableCollection;
import com.exambasic.fluxweb.service.TableCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    private final TableCollectionService tableService;

    @Autowired
    public TableController(TableCollectionService tableService) {
        this.tableService = tableService;
    }

    @GetMapping
    public Flux<TableCollection> getAllTableData() {
        return tableService.getAllTableData();
    }

    @PostMapping("/insert")
    public Mono<TableCollection> insertTableData(@RequestParam String newData) {
        return tableService.insertTableData(newData);
    }

}
//curl -X POST "http://localhost:8090/api/tables/insert?newData=YourDataHere"