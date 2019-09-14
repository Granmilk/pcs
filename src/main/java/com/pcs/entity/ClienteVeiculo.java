package com.pcs.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente_veiculo", schema = "public")
public class ClienteVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente_veiculo")
    private Long idClienteVeiculo;

    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_veiculo",insertable=false,updatable=false, foreignKey = @ForeignKey(name="fk_cliente_veiculo_id_veiculo"))
    private Veiculo veiculo;

    @Column(name = "id_cliente")
    private Long idCliente;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_cliente",insertable=false,updatable=false, foreignKey = @ForeignKey(name="fk_cliente_veiculo_id_cliente"))
    private Cliente cliente;


    public Long getIdClienteVeiculo() {
        return idClienteVeiculo;
    }

    public void setIdClienteVeiculo(Long idClienteVeiculo) {
        this.idClienteVeiculo = idClienteVeiculo;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
