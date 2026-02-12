package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Prato;

import javax.persistence.EntityManager;
import java.util.List;

public class PratoDAO {

    private EntityManager entityManager;

    public PratoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Prato prato) {
        this.entityManager.persist(prato);
    }

    public Prato findById(Long id) {
        return this.entityManager.find(Prato.class, id);
    }

    public void remove(Long id) {
        Prato prato = findById(id);
        if (prato != null) {
            this.entityManager.remove(prato);
        }
    }

    public List<Prato> list() {
        return this.entityManager.createQuery("SELECT p FROM Prato p", Prato.class).getResultList();
    }

    public void update(Long id, Prato prato){
        prato = findById(id);
        if(prato != null){
            this.entityManager.merge(prato);
        }
    }
}
