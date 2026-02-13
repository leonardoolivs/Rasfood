package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Cliente;
import org.h2.api.UserToRolesMapper;

import javax.persistence.EntityManager;
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
