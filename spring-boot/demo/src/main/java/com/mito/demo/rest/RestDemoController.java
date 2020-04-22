package com.mito.demo.rest;

import java.util.List;

import com.mito.demo.model.Persona;
import com.mito.demo.repo.IPersonaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class RestDemoController {

    @Autowired
    private IPersonaRepo repo;

    @GetMapping
    public List<Persona> listar(){
        return repo.findAll();
    }

    @PostMapping
    public void insertar(@RequestBody Persona obj){
        repo.save(obj);
    }

    @PutMapping
    public void modificar(@RequestBody Persona obj){
        repo.save(obj);
    }

    @DeleteMapping(value="/{id}")
    public void borrar(@PathVariable("id") Integer id){
        repo.deleteById(id);
    }
}