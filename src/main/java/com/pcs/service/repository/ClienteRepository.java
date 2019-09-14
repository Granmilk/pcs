package com.pcs.service.repository;

import com.pcs.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Cliente findClienteByCpf(String cpf);

}
