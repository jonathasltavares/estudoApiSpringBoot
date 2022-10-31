package com.algaworks.crm.algacrmapi.repositories;

import com.algaworks.crm.algacrmapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
