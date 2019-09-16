package com.pcs.service.repository;

import com.pcs.entity.Veiculo;
import com.pcs.entity.VeiculoServico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VeiculoServicoRepository extends CrudRepository<VeiculoServico, Long> {

    List<VeiculoServico> getAllByIdVeiculo(Long idVeiculo);

    VeiculoServico getVeiculoServicoByIdVeiculoServico(Long idVeiculoServico);

    VeiculoServico getVeiculoServicoByIdVeiculoAndAndIdServico(Long idVeiculo, Long idServico);


}
