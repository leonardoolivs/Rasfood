package br.com.rasmoo.entities;

import javax.persistence.*;

@Entity
public class OrdensPrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ordem ordem;

    @ManyToOne
    private Prato prato;

    private double valor;

    private int quantidade;

    public OrdensPrato(Prato prato, int quantidade) {
        this.prato = prato;
        this.valor = prato.getPreco();
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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
                ", prato=" + prato +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}