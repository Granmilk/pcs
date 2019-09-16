package com.pcs.controller;

import com.pcs.entity.*;
import com.pcs.service.Services;
import com.pcs.service.crud.*;
import com.pcs.service.repository.ClienteRepository;
import com.pcs.service.repository.ClienteVeiculoRepository;
import com.pcs.service.repository.VeiculoRepository;
import com.pcs.service.repository.VeiculoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoCrud veiculoCrud;
    @Autowired
    private ClienteCrud clienteCrud;
    @Autowired
    private ClienteVeiculoCrud clienteVeiculoCrud;
    @Autowired
    private VeiculoServicoCrud veiculoServicoCrud;
    @Autowired
    private ServicoCrud servicoCrud;
    @Autowired
    private EntityManager entityManager;


    @RequestMapping("/buscar-placa")
    public String verTelaDeBusca(Model model){
        Iterable<ClienteVeiculo> listaClienteVeiculo = clienteVeiculoCrud.getListaClienteVeiculo();

        model.addAttribute("listaClienteVeiculo", listaClienteVeiculo);
        return "telaBuscaPlaca.html";
    }

    @RequestMapping("/buscar-placa/placa")
    public String buscaVeiculo(@RequestParam("placa") String placa, Model model){
        Veiculo veiculo = veiculoCrud.getVeiculoByPlaca(placa.toUpperCase());

        model.addAttribute("veiculo", veiculo);
        return "tabelaBuscaVeiculos.html";
    }
    @RequestMapping("/buscar-veiculo/navbar")
    public String buscaVeiculoOuProprietarioNavbar(@RequestParam("stringBusca") String stringBusca, Model model){
        List<ClienteVeiculo> listaClienteVeiculo = clienteVeiculoCrud.getClienteVeiculoPorBusca(stringBusca);

        model.addAttribute("listaClienteVeiculo", listaClienteVeiculo);
        return "cardDaBusca.html";
    }


    @RequestMapping("/buscar-veiculo")
    public String buscaVeiculoOuProprietario(@RequestParam("stringBusca") String stringBusca, Model model){
        List<ClienteVeiculo> listaClienteVeiculo = clienteVeiculoCrud.getClienteVeiculoPorBusca(stringBusca);

        model.addAttribute("listaClienteVeiculo", listaClienteVeiculo);
        return "tabelaVeiculos.html";
    }

    @RequestMapping("/cadastrar")
    public String telaDeCadastro(){

        return "cadastroVeiculo.html";
    }

    @RequestMapping("/consultar-placa/{placa}")
    public String consultarPlaca(@PathVariable("placa") String placa, Model model){
        ClienteVeiculo clienteVeiculo = clienteVeiculoCrud.getClienteVeiculoByPlaca(placa.toUpperCase());
        List<VeiculoServico> listaVeiculoServico = veiculoServicoCrud.getListaVeiculoServicoById(clienteVeiculo.getIdVeiculo());

        model.addAttribute("listaVeiculoServico", listaVeiculoServico);
        model.addAttribute("clienteVeiculo", clienteVeiculo);
        return "consultaVeiculo.html";
    }


    @RequestMapping("/cadastra-veiculo")
    public String cadastroDeVeiculo(@RequestParam("placa") String placa, @RequestParam("cor") String cor, @RequestParam("marca") String marca, @RequestParam("modelo") String modelo,
                                    @RequestParam("nomeCliente") String nomeCliente, @RequestParam("cpfCliente") String cpf, Model model){

        Veiculo veiculo = veiculoCrud.insereVeiculo(placa.toUpperCase(), cor, marca, modelo);
        Cliente cliente = clienteCrud.insereCliente(nomeCliente, cpf);
        ClienteVeiculo clienteVeiculo = clienteVeiculoCrud.insereClienteVeiculo(cliente.getIdCliente(), veiculo.getIdVeiculo());
        List<VeiculoServico> listaVeiculoServico = veiculoServicoCrud.getListaVeiculoServicoById(clienteVeiculo.getIdVeiculo());
        clienteVeiculo.setCliente(cliente);
        clienteVeiculo.setVeiculo(veiculo);


        model.addAttribute("listaVeiculoServico", listaVeiculoServico);
        model.addAttribute("clienteVeiculo", clienteVeiculo);


        return "consultaVeiculo.html";
    }

    @RequestMapping("/novo-relatorio/{idVeiculo}")
    public String cadastroDeVeiculo(@PathVariable("idVeiculo") Long idVeiculo,  Model model){
        Veiculo veiculo = veiculoCrud.getVeiculoById(idVeiculo);
        model.addAttribute("veiculo", veiculo);

        return "adicionaRelatorio.html";
    }


    @RequestMapping("/cadastra-relatorio")
    public String cadastroDeVeiculo(@RequestParam("placa") String placa, @RequestParam("relatorio") String relatorio, @RequestParam("valor") String valor,  Model model){

        Veiculo veiculo = veiculoCrud.getVeiculoByPlaca(placa.toUpperCase());
        Servico servico = servicoCrud.insereServico(Double.parseDouble(valor.replaceAll(",", ".")), relatorio, new Date());
        VeiculoServico veiculoServico = veiculoServicoCrud.insereVeiculoServico(veiculo.getIdVeiculo(), servico.getIdServico());

        entityManager.clear();
        entityManager.close();
        List<VeiculoServico> listaVeiculoServico = veiculoServicoCrud.getListaVeiculoServicoById(veiculo.getIdVeiculo());


        model.addAttribute("listaVeiculoServico", listaVeiculoServico);

        return "tabelaRelatorio.html";
    }



}
