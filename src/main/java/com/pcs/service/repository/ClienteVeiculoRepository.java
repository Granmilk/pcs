package com.pcs.service.repository;

import com.pcs.entity.ClienteVeiculo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteVeiculoRepository extends CrudRepository<ClienteVeiculo, Long> {

    ClienteVeiculo getClienteVeiculoByVeiculo_Placa(String placa);

    ClienteVeiculo getClienteVeiculoByIdClienteAndIdVeiculo(Long idCliente, Long idVeiculo);


}
