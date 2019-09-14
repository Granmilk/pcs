package com.pcs.service.crud;

import com.pcs.entity.ClienteVeiculo;
import com.pcs.service.repository.ClienteVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteVeiculoCrud {

    @Autowired
    private ClienteVeiculoRepository clienteVeiculoRepository;


    public ClienteVeiculo insereClienteVeiculo(Long idCliente, Long idVeiculo) {
        ClienteVeiculo clienteVeiculo = clienteVeiculoRepository.getClienteVeiculoByIdClienteAndIdVeiculo(idCliente, idVeiculo);
        if(clienteVeiculo == null){
            clienteVeiculo = new ClienteVeiculo();
            clienteVeiculo.setIdVeiculo(idVeiculo);
            clienteVeiculo.setIdCliente(idCliente);
            clienteVeiculo = clienteVeiculoRepository.save(clienteVeiculo);
            return clienteVeiculo;
        }else {
            return clienteVeiculo;
        }

    }

    public ClienteVeiculo getClienteVeiculoByPlaca(String placa) {
       return clienteVeiculoRepository.getClienteVeiculoByVeiculo_Placa(placa);
    }

    public Iterable<ClienteVeiculo> getListaClienteVeiculo() {
        return clienteVeiculoRepository.findAll();
    }
}
