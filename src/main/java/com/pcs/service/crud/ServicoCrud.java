package com.pcs.service.crud;

import com.pcs.entity.Servico;
import com.pcs.service.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ServicoCrud {

    @Autowired
    private ServicoRepository servicoRepository;


    public Servico insereServico(Double valor, String relatorio, Date date) {
        Servico servico = new Servico();
        servico.setData(date);
        servico.setRelatorio(relatorio);
        servico.setValor(valor);
        return servicoRepository.save(servico);
    }
}
