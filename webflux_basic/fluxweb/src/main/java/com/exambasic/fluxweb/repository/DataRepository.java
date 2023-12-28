package com.exambasic.fluxweb.repository;

import com.exambasic.fluxweb.entity.DataEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface DataRepository extends R2dbcRepository<DataEntity,Integer> {
}
