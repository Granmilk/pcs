package com.pcs.service.crud;

import com.pcs.entity.Veiculo;
import com.pcs.entity.VeiculoServico;
import com.pcs.service.repository.VeiculoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class VeiculoServicoCrud {


    @Autowired
    private VeiculoServicoRepository veiculoServicoRepository;
    @Autowired
    private EntityManager entityManager;

    public List<VeiculoServico> getListaVeiculoServicoById(Long idVeiculo) {
        List<VeiculoServico> listaVeiculoServico = entityManager.createQuery("SELECT v FROM VeiculoServico v WHERE v.idVeiculoServico.idVeiculo = :idVeiculo ORDER BY v.idVeiculoServico DESC").setParameter("idVeiculo", idVeiculo).getResultList();
        return listaVeiculoServico;
    }

    public List<VeiculoServico> getListaServicosRecentes(){
        List<VeiculoServico> listaVeiculoServico = entityManager.createQuery("SELECT v FROM VeiculoServico v ORDER BY v.idVeiculoServico DESC").setMaxResults(8).getResultList();
        return listaVeiculoServico;
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
