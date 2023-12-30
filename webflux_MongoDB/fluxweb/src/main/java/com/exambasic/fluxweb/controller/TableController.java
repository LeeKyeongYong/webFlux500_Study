package com.exambasic.fluxweb.controller;

import com.exambasic.fluxweb.document.TableCollection;
import com.exambasic.fluxweb.service.TableCollectionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    private final TableCollectionService tableService;

    @Autowired
    public TableController(TableCollectionService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/")
    public Flux<TableCollection> getAllTableData() {
        return tableService.getAllTableData();
    }

    @RequestMapping(value="/insert", method = {RequestMethod.GET, RequestMethod.POST})
    public Mono<TableCollection> insertTableData(@RequestParam String newData,RequestMethod method) {
        return tableService.insertTableData(newData);
    }

}
//curl -X POST "http://localhost:8090/api/tables/insert?newData=YourDataHere"