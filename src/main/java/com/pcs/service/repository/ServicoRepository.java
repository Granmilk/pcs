package com.pcs.service.repository;

import com.pcs.entity.Servico;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ServicoRepository extends CrudRepository<Servico, Long> {

    Servico getServicoByIdServico(Long idServico);
    List<Servico> getServicosByDataBetween(Date dataInicio, Date dataFim);


}
