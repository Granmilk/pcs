package com.pcs.service.crud;

import com.pcs.entity.Veiculo;
import com.pcs.entity.VeiculoServico;
import com.pcs.service.repository.VeiculoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class VeiculoServicoCrud {


    @Autowired
    private VeiculoServicoRepository veiculoServicoRepository;

    public List<VeiculoServico> getListaVeiculoServicoById(Long idVeiculo) {
        return veiculoServicoRepository.getAllByIdVeiculo(idVeiculo);
    }

    public VeiculoServico insereVeiculoServico(Long idVeiculo, Long idServico) {
        VeiculoServico veiculoServico = veiculoServicoRepository.getVeiculoServicoByIdVeiculoAndAndIdServico(idVeiculo, idServico);
        if(veiculoServico == null){
            veiculoServico = new VeiculoServico();
            veiculoServico.setIdVeiculo(idVeiculo);
            veiculoServico.setIdServico(idServico);
            veiculoServico = veiculoServicoRepository.save(veiculoServico);
            return veiculoServico;
        }else{
            return veiculoServico;
        }

    }
}
