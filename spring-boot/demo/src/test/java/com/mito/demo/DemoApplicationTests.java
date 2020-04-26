package com.mito.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mito.demo.model.Usuario;
import com.mito.demo.repo.IUsuarioRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private IUsuarioRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(3);
		us.setNombre("mito");
		us.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(us);

		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
