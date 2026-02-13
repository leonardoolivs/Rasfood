package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Ordem;
import org.h2.api.UserToRolesMapper;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrdemDAO {

    private EntityManager entityManager;

    public OrdemDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem findById(Long id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public void remove(Long id) {
        Ordem ordem = findById(id);
        if (ordem != null) {
            this.entityManager.remove(ordem);
        }
    }

    public List<Ordem> list() {
        return this.entityManager
                .createQuery("SELECT p FROM Ordem p", Ordem.class).getResultList();
    }

    public void update(Long id, Ordem ordem) {
        ordem = findById(id);
        if (ordem != null) {
            this.entityManager.merge(ordem);
        }
    }
}
