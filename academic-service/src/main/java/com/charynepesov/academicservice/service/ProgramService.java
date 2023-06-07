package com.charynepesov.academicservice.service;

import com.charynepesov.academicservice.exception.ResourceAlreadyExistsException;
import com.charynepesov.academicservice.exception.ResourceDoesNotExistException;
import com.charynepesov.academicservice.model.Program;
import com.charynepesov.academicservice.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

    // find by id
    public Program findById(int id) throws ResourceDoesNotExistException {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()){
            return optionalProgram.get();
        } else throw new ResourceDoesNotExistException(String.valueOf(id));
    }

    // find all
    public List<Program> findAll(){
        return programRepository.findAll();
    }

    // insert
    public Program insert(Program program) throws ResourceAlreadyExistsException {
        Optional<Program> optionalProgram = programRepository.findById(program.getId());
        if (optionalProgram.isPresent()){
            throw new ResourceAlreadyExistsException(String.valueOf(program.getId()));
        } return programRepository.save(program);
    }

    // delete by id
    public boolean deleteById(int id) throws ResourceDoesNotExistException {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()){
            programRepository.deleteById(id);
        } else throw new ResourceDoesNotExistException(String.valueOf(id));
        return true;
    }

    // delete all
    public boolean deleteAll(){
        programRepository.deleteAll();
        return true;
    }

    // update
    public Program update(int id, Program program) throws ResourceDoesNotExistException {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()){
            program.setId(id);
            return programRepository.save(program);
        } else throw new ResourceDoesNotExistException(String.valueOf(id));
    }
}
