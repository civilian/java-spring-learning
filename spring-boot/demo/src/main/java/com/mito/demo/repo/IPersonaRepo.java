package com.mito.demo.repo;

import com.mito.demo.model.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}