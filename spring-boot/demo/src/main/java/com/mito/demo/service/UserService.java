package com.mito.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.mito.demo.model.Usuario;
import com.mito.demo.repo.IUsuarioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUsuarioRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us = repo.findByNombre(username);
        List<GrantedAuthority> roles = new ArrayList();
        // Roles se pueden poblar con base de datos
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDet = new User(us.getNombre(), us.getClave(), roles);

        return userDet;
	}
}