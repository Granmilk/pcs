package com.pcs.service.crud;

import com.pcs.entity.Veiculo;
import com.pcs.entity.VeiculoServico;
import com.pcs.service.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VeiculoCrud {


    @Autowired
    private VeiculoRepository veiculoRepository;


    public Veiculo insereVeiculo(String placa, String cor, String marca, String modelo) {
        Veiculo veiculo = veiculoRepository.getVeiculoByPlaca(placa);
        if(veiculo == null) {
            veiculo = new Veiculo();
            veiculo.setCor(cor);
            veiculo.setMarca(marca);
            veiculo.setModelo(modelo);
            veiculo.setPlaca(placa);
            veiculo = veiculoRepository.save(veiculo);
            return veiculo;
        }
        else{
            return veiculo;
        }
    }

    public Veiculo getVeiculoByPlaca(String placa) {
        return veiculoRepository.getVeiculoByPlaca(placa);
    }

    public Veiculo getVeiculoById(Long idVeiculo) {

        Veiculo veiculo = veiculoRepository.getVeiculoByIdVeiculo(idVeiculo);
        return veiculo;
    }
}
