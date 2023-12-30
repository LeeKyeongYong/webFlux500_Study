package com.exambasic.fluxweb.first.repository;

import com.exambasic.fluxweb.first.entity.FirstEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

public interface FirstRepository extends R2dbcRepository<FirstEntity,Integer> {
}
