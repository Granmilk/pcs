package com.pcs.service.repository;

import com.pcs.entity.Veiculo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

    Veiculo getVeiculoByPlaca(String placa);

    Veiculo getVeiculoByIdVeiculo(Long idVeiculo);


}
