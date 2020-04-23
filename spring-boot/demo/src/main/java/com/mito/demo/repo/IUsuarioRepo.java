package com.mito.demo.repo;

import com.mito.demo.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

}