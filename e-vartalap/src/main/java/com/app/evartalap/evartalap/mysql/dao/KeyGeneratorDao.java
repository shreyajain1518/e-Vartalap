package com.app.evartalap.evartalap.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.evartalap.evartalap.mysql.pojos.KeyGenerator;

public interface KeyGeneratorDao extends JpaRepository<KeyGenerator,Integer> {

@Query("Select u from KeyGenerator u where id = ?1")
KeyGenerator findByIdnum(Integer id);
}
