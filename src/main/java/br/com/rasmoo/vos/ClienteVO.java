package br.com.rasmoo.vos;

public class ClienteVO {

    private String nome;
    private String cpf;

    public ClienteVO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteVO(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClienteVO{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
