package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Endereco;
import org.h2.api.UserToRolesMapper;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class EnderecoDAO {

    private EntityManager entityManager;

    public EnderecoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public Endereco findById(Long id) {
        return this.entityManager.find(Endereco.class, id);
    }

    public void remove(Long id) {
        Endereco endereco = findById(id);
        if (endereco != null) {
            this.entityManager.remove(endereco);
        }
    }

    public List<Endereco> list() {
        return this.entityManager
                .createQuery("SELECT p FROM Endereco p", Endereco.class).getResultList();
    }

    public void update(Long id, Endereco endereco) {
        endereco = findById(id);
        if (endereco != null) {
            this.entityManager.merge(endereco);
        }
    }
}
