package br.com.rasmoo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valorTotal;
    private LocalDate dataCriacao;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    private Set<OrdensPrato> ordensPratosList = new HashSet<>();

    public Ordem(LocalDate dataCriacao, Cliente cliente) {
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
    }

    public Ordem(){
    }

    public void addOrdensPrato(OrdensPrato ordensPrato){
        ordensPrato.setOrdem(this);
        this.ordensPratosList.add(ordensPrato);
        this.valorTotal += ordensPrato.getValor() * ordensPrato.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                ", ordensPratosList=" + ordensPratosList +
                '}';
    }
}
