package com.charynepesov.humanresourcesservice.repository;

import com.charynepesov.humanresourcesservice.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
