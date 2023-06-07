package com.charynepesov.academicservice.repository;

import com.charynepesov.academicservice.model.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends MongoRepository<Program, Integer> {
}
