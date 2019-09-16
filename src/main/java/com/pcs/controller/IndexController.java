package com.pcs.controller;


import com.pcs.entity.ClienteVeiculo;
import com.pcs.entity.Servico;
import com.pcs.entity.VeiculoServico;
import com.pcs.service.crud.ClienteVeiculoCrud;
import com.pcs.service.crud.VeiculoServicoCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    private VeiculoServicoCrud veiculoServicoCrud;
    @Autowired
    private ClienteVeiculoCrud clienteVeiculoCrud;


    @RequestMapping("/")
    public String index(Model model){
        List<VeiculoServico> listaVeiculoServico = veiculoServicoCrud.getListaServicosRecentes();
        List<ClienteVeiculo> listaClienteVeiculo = clienteVeiculoCrud.getListaClienteVeiculoRecentes();

        model.addAttribute("listaVeiculoServico", listaVeiculoServico);
        model.addAttribute("listaClienteVeiculo", listaClienteVeiculo);
        return "index.html";
    }



}
