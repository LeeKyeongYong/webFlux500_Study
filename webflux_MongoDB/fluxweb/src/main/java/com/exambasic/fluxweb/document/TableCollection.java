package com.exambasic.fluxweb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document//(collation = "table1") 속성제거
@Data
public class TableCollection {
    @Id
    private String _id;
    private String data;
}
