package com.pcs.service.crud;

import com.pcs.entity.ClienteVeiculo;
import com.pcs.service.repository.ClienteVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ClienteVeiculoCrud {

    @Autowired
    private ClienteVeiculoRepository clienteVeiculoRepository;
    @Autowired
    private EntityManager entityManager;


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

    public List<ClienteVeiculo> getListaClienteVeiculoRecentes(){
        List<ClienteVeiculo> listaClienteVeiculo = entityManager.createQuery("SELECT c FROM ClienteVeiculo c ORDER BY c.idClienteVeiculo DESC").setMaxResults(10).getResultList();
        return listaClienteVeiculo;

    }

    public List<ClienteVeiculo> getClienteVeiculoPorBusca(String stringBusca) {
        stringBusca = stringBusca.trim().replaceAll(" ", "%");
        List<ClienteVeiculo> listaClienteVeiculoByPlaca = entityManager.createQuery("SELECT c FROM ClienteVeiculo c WHERE UPPER(c.veiculo.placa) LIKE UPPER(:placa) ORDER BY c.idClienteVeiculo DESC").setParameter("placa", "%"+stringBusca+"%").getResultList();
        List<ClienteVeiculo> listaClienteVeiculoByNomeCliente = entityManager.createQuery("SELECT c FROM ClienteVeiculo c WHERE UPPER(c.cliente.nome) LIKE UPPER(:nome) ORDER BY c.idClienteVeiculo DESC").setParameter("nome", "%"+stringBusca+"%").getResultList();
        for(ClienteVeiculo clienteVeiculo : listaClienteVeiculoByNomeCliente){
            if(!listaClienteVeiculoByPlaca.contains(clienteVeiculo)){
                listaClienteVeiculoByPlaca.add(clienteVeiculo);
            }
        }
        return listaClienteVeiculoByPlaca;
    }
}
