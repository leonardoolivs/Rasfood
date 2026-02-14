package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Cliente;
import br.com.rasmoo.vos.ClienteVO;
import org.h2.api.UserToRolesMapper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class ClienteDAO {

    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public Cliente findById(Long id) {
        return this.entityManager.find(Cliente.class, id);
    }

    public void remove(Long id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            this.entityManager.remove(cliente);
        }
    }

    public Cliente listPerName(String name) {
        return this.entityManager
                .createQuery("SELECT p FROM Cliente p WHERE p.nome = :name", Cliente.class)
                .setParameter("name", name).getSingleResult();
    }

    public List<Cliente> listLikeName(String nome) {
        String jpql = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome";
        return this.entityManager.createQuery(jpql, Cliente.class).setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<ClienteVO> listarPorEndereco(String estado, String cidade, String rua) {
        String jpql = "SELECT new br.com.rasmoo.vos.ClienteVO(e.cliente.nome, e.cliente.cpf)" +
                " FROM Endereco e WHERE 1=1 ";

        if(estado != null){
            jpql = jpql.concat("AND e.estado = :estado ");
        }

        if(cidade != null){
            jpql = jpql.concat("AND e.cidade = :cidade ");
        }

        if(rua != null){
            jpql = jpql.concat("AND e.rua = :rua");
        }

        TypedQuery typedQuery = this.entityManager.createQuery(jpql, ClienteVO.class);

        if(estado != null){
            typedQuery.setParameter("estado", estado);
        }

        if(cidade != null){
            typedQuery.setParameter("cidade", cidade);
        }

        if(rua != null){
            typedQuery.setParameter("rua", rua);
        }

        return typedQuery.getResultList();
    }

    public List<Cliente> list() {
        return this.entityManager
                .createQuery("SELECT p FROM Cliente p", Cliente.class).getResultList();
    }

    public void update(Long id, Cliente cliente) {
        cliente = findById(id);
        if (cliente != null) {
            this.entityManager.merge(cliente);
        }
    }
}
