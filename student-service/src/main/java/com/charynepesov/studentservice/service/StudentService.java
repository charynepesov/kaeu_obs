package com.charynepesov.studentservice.service;

import com.charynepesov.studentservice.exception.ResourceAlreadyExistsException;
import com.charynepesov.studentservice.exception.ResourceDoesNotExistException;
import com.charynepesov.studentservice.model.Student;
import com.charynepesov.studentservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    // find by id
    public Student findById(String id) throws ResourceDoesNotExistException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            return optionalStudent.get();
        } else throw new ResourceDoesNotExistException(id);
    }

    // find all
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    // insert
    public Student insert(Student student) throws ResourceAlreadyExistsException {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()){
            throw new ResourceAlreadyExistsException(student.getId());
        } return studentRepository.save(student);
    }

    // delete by id
    public boolean deleteById(String id) throws ResourceDoesNotExistException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            studentRepository.deleteById(id);
        } else throw new ResourceDoesNotExistException(id);
        return true;
    }

    // delete all
    public boolean deleteAll(){
        studentRepository.deleteAll();
        return true;
    }

    // update
    public Student update(String id, Student student) throws ResourceDoesNotExistException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            student.setId(id);
            return studentRepository.save(student);
        } else throw new ResourceDoesNotExistException(id);
    }
}
