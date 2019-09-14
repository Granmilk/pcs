package com.pcs.entity;

import javax.persistence.*;

@Entity
@Table(name = "veiculo_servico", schema = "public")
public class VeiculoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo_servico")
    private Long idVeiculoServico;

    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_veiculo",insertable=false,updatable=false, foreignKey = @ForeignKey(name="fk_veiculo_servico_id_veiculo"))
    private Veiculo veiculo;

    @Column(name = "id_servico")
    private Long idServico;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_servico",insertable=false,updatable=false, foreignKey = @ForeignKey(name="fk_veiculo_servico_id_servico"))
    private Servico servico;


    public Long getIdVeiculoServico() {
        return idVeiculoServico;
    }

    public void setIdVeiculoServico(Long idVeiculoServico) {
        this.idVeiculoServico = idVeiculoServico;
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

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
