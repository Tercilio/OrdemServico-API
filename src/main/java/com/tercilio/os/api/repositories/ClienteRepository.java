package com.tercilio.os.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tercilio.os.api.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
