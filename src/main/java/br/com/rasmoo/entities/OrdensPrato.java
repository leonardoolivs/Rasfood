package br.com.rasmoo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrdensPrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ordem ordem;

    @ManyToOne
    private Prato prato;

    private BigDecimal valor;

    private int quantidade;

    public OrdensPrato(Prato prato, BigDecimal valor, int quantidade) {
        this.prato = prato;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public OrdensPrato(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "OrdensPrato{" +
                "id=" + id +
                ", ordem=" + ordem +
                ", prato=" + prato +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}