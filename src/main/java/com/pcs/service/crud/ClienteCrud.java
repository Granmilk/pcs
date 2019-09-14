package com.pcs.service.crud;

import com.pcs.entity.Cliente;
import com.pcs.service.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteCrud {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insereCliente(String nomeCliente, String cpf) {
        Cliente cliente = clienteRepository.findClienteByCpf(cpf);
        if(cliente == null){
            cliente = new Cliente();
            cliente.setNome(nomeCliente);
            cliente.setCpf(cpf);
            cliente = clienteRepository.save(cliente);
            return cliente;
        }else {
            return cliente;
        }

    }

}
