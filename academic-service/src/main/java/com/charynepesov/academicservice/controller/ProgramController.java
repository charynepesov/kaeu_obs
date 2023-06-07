package com.charynepesov.academicservice.controller;

import com.charynepesov.academicservice.exception.ResourceAlreadyExistsException;
import com.charynepesov.academicservice.exception.ResourceDoesNotExistException;
import com.charynepesov.academicservice.model.Program;
import com.charynepesov.academicservice.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/programs")
@RequiredArgsConstructor
public class ProgramController {
    private final ProgramService programService;

    @GetMapping("")
    public ResponseEntity<List<Program>> getAll(){
        List<Program> programList = programService.findAll();
        return ResponseEntity.ok(programList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getById(@PathVariable int id){
        try{
            Program Program = programService.findById(id);
            return ResponseEntity.ok(Program);

        } catch (ResourceDoesNotExistException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Program> insert(@RequestBody Program Program){
        try{
            Program insertedProgram = programService.insert(Program);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertedProgram);
        } catch (ResourceAlreadyExistsException e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable int id){
        try{
            boolean deleted = programService.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (ResourceDoesNotExistException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> update(@PathVariable int id, @RequestBody Program Program){
        try{
            Program updatedProgram = programService.update(id, Program);
            return ResponseEntity.ok(updatedProgram);
        } catch (ResourceDoesNotExistException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
