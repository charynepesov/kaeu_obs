package com.charynepesov.humanresourcesservice.service;

import com.charynepesov.humanresourcesservice.exception.ResourceAlreadyExistsException;
import com.charynepesov.humanresourcesservice.exception.ResourceDoesNotExistException;
import com.charynepesov.humanresourcesservice.model.Employee;
import com.charynepesov.humanresourcesservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    // find by id
    public Employee findById(String id) throws ResourceDoesNotExistException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            return optionalEmployee.get();
        } else throw new ResourceDoesNotExistException(id);
    }

    // find all
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    // insert
    public Employee insert(Employee employee) throws ResourceAlreadyExistsException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if (optionalEmployee.isPresent()){
            throw new ResourceAlreadyExistsException(employee.getId());
        } return employeeRepository.save(employee);
    }

    // delete by id
    public boolean deleteById(String id) throws ResourceDoesNotExistException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
        } else throw new ResourceDoesNotExistException(id);
        return true;
    }

    // delete all
    public boolean deleteAll(){
        employeeRepository.deleteAll();
        return true;
    }

    // update
    public Employee update(String id, Employee employee) throws ResourceDoesNotExistException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            employee.setId(id);
            return employeeRepository.save(employee);
        } else throw new ResourceDoesNotExistException(id);
    }
}
