package com.exambasic.fluxweb.second.repository;

import com.exambasic.fluxweb.second.entity.SecondEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface SecondRepository  extends R2dbcRepository<SecondEntity,Integer> {
}