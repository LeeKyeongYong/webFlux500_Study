package com.exambasic.fluxweb.repository;


import com.exambasic.fluxweb.document.TableCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends ReactiveMongoRepository<TableCollection,String> {}
